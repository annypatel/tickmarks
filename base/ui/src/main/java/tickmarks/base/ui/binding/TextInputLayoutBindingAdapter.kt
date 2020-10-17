package tickmarks.base.ui.binding

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

/**
 * Sets [error][TextInputLayout.setError] on the given TextInputLayout.
 */
@BindingAdapter("error")
fun TextInputLayout.setError(@StringRes resId: Int) {
    error = if (resId == NONE) null else context.getString(resId)
}
