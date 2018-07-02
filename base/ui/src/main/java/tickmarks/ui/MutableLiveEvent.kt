package tickmarks.ui

/**
 * [LiveEvent] which publicly exposes [event] (alias for value) and [data] properties.
 */
open class MutableLiveEvent<T> : LiveEvent<T>() {

    var event: Event<T>?
        get() = value
        set(event) {
            value = event
        }

    var data: T
        get() = checkNotNull(value).peek()
        set(data) {
            value = Event(data)
        }
}
