package tickmarks.base.ui.event

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class EventTest {

    @Test
    fun consume_givenUnconsumedEvent_shouldCallConsumerOnce() {
        val event = Event("EventData")
        val mockedConsumer = mock<(Event<String>) -> Unit>()

        event.consume(mockedConsumer)

        verify(mockedConsumer, times(1)).invoke(event)
    }

    @Test
    fun consume_givenConsumedEvent_shouldNeverCallConsumer() {
        val event = Event("EventData")
        val mockedConsumer = mock<(Event<String>) -> Unit>()
        event.consume {}

        event.consume(mockedConsumer)

        verify(mockedConsumer, never()).invoke(any())
    }

    @Test
    fun consume_givenUnconsumedEvent_consumedShouldBeTrue() {
        val event = Event("EventData")

        event.consume {}

        assertThat(event.consumed, equalTo(true))
    }
}
