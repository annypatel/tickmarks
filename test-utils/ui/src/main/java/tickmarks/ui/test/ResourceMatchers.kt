package tickmarks.ui.test

import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matcher

/**
 * Creates a matcher that matches string with string resource id.
 */
fun equalToRes(@StringRes resId: Int): Matcher<CharSequence?> {
    val string = getInstrumentation().targetContext.getString(resId)
    return equalTo(string)
}
