package tickmarks.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter
import tickmarks.ui.binding.Visibility.GONE
import tickmarks.ui.binding.Visibility.INVISIBLE
import tickmarks.ui.binding.Visibility.VISIBLE

/**
 * Defines [BindingAdapter]s for a [View].
 */
object ViewBindingAdapter {

    /**
     * Sets [visibility][View.setVisibility] of the given view.
     */
    @JvmStatic
    @BindingAdapter("visibility")
    fun setVisibility(view: View, visibility: Visibility?) {
        when (visibility) {
            VISIBLE -> view.visibility = View.VISIBLE
            INVISIBLE -> view.visibility = View.INVISIBLE
            GONE -> view.visibility = View.GONE
        }
    }
}