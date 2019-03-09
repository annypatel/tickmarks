package tickmarks.ui.test

import android.content.Context
import android.view.ContextThemeWrapper
import androidx.test.core.app.ApplicationProvider
import tickmarks.test.utils.ui.R

/**
 * Returns ContextThemeWrapper with AppCompat theme.
 */
fun themedContext(): ContextThemeWrapper {
    val context = ApplicationProvider.getApplicationContext<Context>()
    return ContextThemeWrapper(context, R.style.Theme_AppCompat)
}
