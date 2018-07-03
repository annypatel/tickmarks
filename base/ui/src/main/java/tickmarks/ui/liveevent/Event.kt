package tickmarks.ui.liveevent

/**
 * Used as a wrapper for data that is exposed via a [LiveEvent] that represents an event.
 */
class Event<out T>(
    private val data: T
) {

    /**
     * Represents state of an event, true if consumed and false if not.
     */
    var consumed = false
        private set

    /**
     * To consume the data wrapped inside this event. [Consumer][consumer] will be not be called if event is already
     * consumed once.
     */
    fun consume(consumer: (T) -> Unit) {
        if (!consumed) {
            consumed = true
            consumer(data)
        }
    }

    /**
     * Retrieves, but does not consume the data inside this event.
     */
    fun peek() = data
}