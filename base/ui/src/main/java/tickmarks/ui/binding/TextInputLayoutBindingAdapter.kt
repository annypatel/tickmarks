package tickmarks.ui.binding

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

/**
 * Sets [error][TextInputLayout.setError] on the given TextInputLayout.
 */
@BindingAdapter("error")
fun TextInputLayout.setError(@StringRes resId: Int) {
    when (resId) {
        NONE -> error = null
        else -> error = context.getString(resId)
    }
}