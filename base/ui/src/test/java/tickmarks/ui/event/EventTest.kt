package tickmarks.ui.event

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as Is

class EventTest {

    @Test
    fun consume_givenUnconsumedEvent_shouldCallConsumerOnce() {
        val mockedConsumer = mock<(String) -> Unit>()
        val expectedData = "EventData"
        val event = Event(expectedData)

        event.consume(mockedConsumer)

        verify(mockedConsumer, times(1)).invoke(expectedData)
        assertThat(event.peek(), Is(expectedData))
    }

    @Test
    fun consume_givenConsumedEvent_shouldNeverCallConsumer() {
        val mockedConsumer = mock<(String) -> Unit>()
        val expectedData = "EventData"
        val event = Event(expectedData)
        event.consume {}

        event.consume(mockedConsumer)

        verify(mockedConsumer, never()).invoke(expectedData)
        assertThat(event.peek(), Is(expectedData))
    }

    @Test
    fun consume_givenUnconsumedEvent_shouldConsumeEvent() {
        val expectedData = "EventData"
        val event = Event(expectedData)

        val actualData = event.consume()

        assertThat(event.consumed, Is(true))
        assertThat(actualData, Is(expectedData))
    }

    @Test
    fun consume_givenUnconsumedEvent_consumedShouldBeTrue() {
        val expectedData = "EventData"
        val event = Event(expectedData)

        event.consume {}

        assertThat(event.consumed, Is(true))
    }
}