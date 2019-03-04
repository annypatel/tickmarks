package tickmarks.ui.test

import android.content.Context
import androidx.annotation.StringRes
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matcher

/**
 * Creates a matcher that matches string with string resource id.
 */
fun equalToRes(@StringRes resId: Int): Matcher<CharSequence?> {
    val string = getApplicationContext<Context>().getString(resId)
    return equalTo(string)
}
