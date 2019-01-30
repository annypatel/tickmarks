package tickmarks.ui.test.binding

import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import tickmarks.ui.R

/**
 * Inflates a binding layout and returns the newly-created binding for that layout.
 */
fun <T : ViewDataBinding> inflate(@LayoutRes layout: Int): T {
    val context = ContextThemeWrapper(getInstrumentation().targetContext, R.style.Theme_AppCompat)

    val inflater = LayoutInflater.from(context)
    val parent = FrameLayout(context)

    val binding = DataBindingUtil.inflate<T>(inflater, layout, parent, true)
    binding.executePendingBindings()
    return binding
}

/**
 * Executes pending binding right away.
 */
inline fun <T : ViewDataBinding> T.bindNow(call: () -> Unit) {
    call()
    executePendingBindings()
}
