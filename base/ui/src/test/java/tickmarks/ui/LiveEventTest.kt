package tickmarks.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LiveEventTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var owner: LifecycleOwner
    private lateinit var lifecycle: LifecycleRegistry

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        lifecycle = LifecycleRegistry(owner)
        whenever(owner.lifecycle).thenReturn(lifecycle)

        // start with onCreate
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    @Test
    fun setTwoEvents_givenLiveEvent_consumerCalledTwice() {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        val expectedData1 = 23
        val expectedData2 = 64
        val mockedConsumer = mock<(Int) -> Unit>()
        val liveEvent = TestLiveEvent<Int>()

        // start observing
        liveEvent.observe(owner, mockedConsumer)
        // set event
        liveEvent.value = Event(expectedData1)
        // set different event
        liveEvent.value = Event(expectedData2)

        verify(mockedConsumer, times(1)).invoke(expectedData1)
        verify(mockedConsumer, times(1)).invoke(expectedData2)
    }

    @Test
    fun setEventResumeTwice_givenLiveEvent_consumerCalledOnce() {
        val mockedConsumer1 = mock<(Int) -> Unit>()
        val mockedConsumer2 = mock<(Int) -> Unit>()
        val expectedData = 123
        val liveEvent = TestLiveEvent<Int>()

        // Start observing
        liveEvent.observe(owner, mockedConsumer1)
        // After value is set
        liveEvent.value = Event(expectedData)
        with(lifecycle) {
            // on resume, consumer should be called once
            handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

            // on second resume, consumer should not be called
            handleLifecycleEvent(Lifecycle.Event.ON_STOP)
            handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        }
        // After second resume, start observing again
        liveEvent.observe(owner, mockedConsumer2)

        verify(mockedConsumer1, times(1)).invoke(expectedData)
        verify(mockedConsumer2, never()).invoke(expectedData)
    }

    @Test
    fun setEventResumeTwice_givenLiveEvent_observerCalledTwice() {
        val mockedObserver1 = mock<Observer<Event<Int>>>()
        val mockedObserver2 = mock<Observer<Event<Int>>>()
        val expectedEvent = Event(123)
        val liveEvent = TestLiveEvent<Int>()

        // Start observing
        liveEvent.observe(owner, mockedObserver1)
        // After value is set
        liveEvent.value = expectedEvent
        with(lifecycle) {
            // on resume, observer should be called once
            handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

            // on second resume, observer should be called once
            handleLifecycleEvent(Lifecycle.Event.ON_STOP)
            handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        }
        // After second resume, start observing again
        liveEvent.observe(owner, mockedObserver2)

        verify(mockedObserver1, times(1)).onChanged(expectedEvent)
        verify(mockedObserver2, times(1)).onChanged(expectedEvent)
    }

    class TestLiveEvent<T> : LiveEvent<T>() {

        // change visibility to public from protected
        public override fun setValue(value: Event<T>?) {
            super.setValue(value)
        }
    }
}