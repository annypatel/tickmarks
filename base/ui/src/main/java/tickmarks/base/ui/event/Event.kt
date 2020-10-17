package tickmarks.base.ui.event

/**
 * Simple base event with state of its consumption.
 */
open class BaseEvent {

    /**
     * Represents state of an event, true if consumed and false if not.
     */
    var consumed: Boolean = false
}

/**
 * Used as a wrapper for data that is exposed as an event.
 */
data class Event<T>(
    val data: T
) : BaseEvent()

/**
 * To consume this event. [Consumer][consumer] will be not be called if event is already
 * consumed.
 */
inline fun <T : BaseEvent> T.consume(consumer: (T) -> Unit) {
    if (!consumed) {
        consumed = true
        consumer(this)
    }
}
