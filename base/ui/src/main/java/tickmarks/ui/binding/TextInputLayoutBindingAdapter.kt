package tickmarks.ui.binding

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

/**
 * Defines [BindingAdapter]s for [TextInputLayout].
 */
object TextInputLayoutBindingAdapter {

    /**
     * Sets [error][TextInputLayout.setError] on the given TextInputLayout.
     */
    @JvmStatic
    @BindingAdapter("error")
    fun setError(til: TextInputLayout, @StringRes resId: Int) {
        when (resId) {
            NONE -> til.error = null
            else -> til.error = til.context.getString(resId)
        }
    }
}