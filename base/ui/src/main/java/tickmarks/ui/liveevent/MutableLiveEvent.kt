package tickmarks.ui.liveevent

import tickmarks.ui.event.Event

/**
 * [LiveEvent] which publicly exposes [event] (alias for value) property and [get]/[set] for event data.
 */
open class MutableLiveEvent<T> : LiveEvent<T>() {

    var event: Event<T>?
        get() = value
        set(event) {
            value = event
        }

    fun get() = value?.peek()

    fun set(data: T) {
        value = Event(data)
    }
}
