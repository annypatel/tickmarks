package tickmarks.ui.liveevent

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MutableLiveEventTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var owner: LifecycleOwner

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        val lifecycle = LifecycleRegistry(owner)
        whenever(owner.lifecycle).thenReturn(lifecycle)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    @Test
    fun setEvent_observeLiveEvent_observerShouldBeCalled() {
        val mockedObserver = mock<Observer<Event<Int>>>()
        val liveEvent = MutableLiveEvent<Int>()
        liveEvent.observe(owner, mockedObserver)

        liveEvent.event = Event(123)

        verify(mockedObserver).onChanged(any())
    }

    @Test
    fun setData_observeLiveEvent_observerShouldBeCalled() {
        val mockedObserver = mock<Observer<Event<Int>>>()
        val liveEvent = MutableLiveEvent<Int>()
        liveEvent.observe(owner, mockedObserver)

        liveEvent.data = 123

        verify(mockedObserver).onChanged(any())
    }

    @Test(expected = IllegalStateException::class)
    fun getData_givenEmptyLiveEvent_throwsException() {
        val liveEvent = MutableLiveEvent<Int>()
        liveEvent.data
    }
}