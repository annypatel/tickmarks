package tickmarks.base.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import tickmarks.base.ui.binding.Visibility.GONE
import tickmarks.base.ui.binding.Visibility.INVISIBLE
import tickmarks.base.ui.binding.Visibility.VISIBLE

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
