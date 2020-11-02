package tickmarks.base.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar
import tickmarks.base.ui.event.Event
import tickmarks.base.ui.event.consume

/**
 * Shows snackbar with the string resource id wrapped inside an event.
 *
 * Note: The string resource is wrapped inside an event because showing a snackbar is an event,
 * which should be consumed only once.
 */
@BindingAdapter("snackbar")
fun View.showSnackbar(event: Event<Int>?) {
    event?.consume {
        val resId = it.data
        if (resId != NONE) {
            Snackbar.make(this, resId, Snackbar.LENGTH_LONG).show()
        }
    }
}
