package tickmarks.ui.liveevent

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import tickmarks.ui.event.Event

/**
 * LiveEvent is a [LiveData] that wraps data inside an [Event]. Use LiveEvent instead of [LiveData] when the data
 * should be consumed only once(like a snackbar message, a navigation event or a dialog trigger).
 *
 * To consume data inside the event directly, use [observe] method with consumer of type ```(T) -> Unit```.
 * ```
 *      val liveEvent = viewModel.snackbarEvent
 *      liveEvent.observe(lifecycleOwner) {
 *           // consume event
 *      }
 * ```
 * Or to consume the event, use [observe] method with [Observer].
 * ```
 *      val liveEvent = viewModel.snackbarEvent
 *      liveEvent.observe(lifecycleOwner, Observer<Event<String>> {
 *           it?.consume {
 *               // consume event
 *           }
 *      })
 * ```
 */
abstract class LiveEvent<T> : LiveData<Event<T>>() {

    /**
     * To observe LiveEvent with a consumer. [Consumer][consumer] will be called only for new events. If event is
     * already consumed once then consumer will not be called.
     */
    fun observe(owner: LifecycleOwner, consumer: (T) -> Unit) {
        observe(owner, Observer {
            it?.consume(consumer)
        })
    }
}