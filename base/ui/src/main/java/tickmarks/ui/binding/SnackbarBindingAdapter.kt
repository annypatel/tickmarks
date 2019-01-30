package tickmarks.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar
import tickmarks.ui.event.Event
import tickmarks.ui.event.consume

/**
 * Defines [BindingAdapter]s for a [Snackbar].
 */
object SnackbarBindingAdapter {

    /**
     * Shows snackbar with the string resource id wrapped inside an event.
     *
     * Note: The string resource is wrapped inside an event because showing a snackbar is an event, which should be
     * consumed only once.
     */
    @JvmStatic
    @BindingAdapter("snackbar")
    fun showSnackbar(view: View, event: Event<Int>) {
        event.consume {
            val resId = it.data
            if (resId != NONE) {
                Snackbar.make(view, resId, Snackbar.LENGTH_LONG).show()
            }
        }
    }
}