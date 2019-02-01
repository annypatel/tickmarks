package tickmarks.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import tickmarks.ui.binding.Visibility.GONE
import tickmarks.ui.binding.Visibility.INVISIBLE
import tickmarks.ui.binding.Visibility.VISIBLE

/**
 * Sets [visibility][View.setVisibility] of the given view.
 */
@BindingAdapter("visibility")
fun View.setVisibility(visibility: Visibility?) {
    when (visibility) {
        VISIBLE -> this.visibility = View.VISIBLE
        INVISIBLE -> this.visibility = View.INVISIBLE
        GONE -> this.visibility = View.GONE
    }
}