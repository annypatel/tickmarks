package tickmarks.test.ui

import android.content.res.Resources
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.util.HumanReadables.describe
import com.google.android.material.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Creates matcher that verifies that view doesn't have Snackbar.
 */
fun hasNoSnackbar(): Matcher<View> =
    FindViewByIdMatcher(R.id.snackbar_text, nullValue(View::class.java))

/**
 * Creates matcher that verifies that view has Snackbar.
 */
fun hasSnackbar(vararg matchers: Matcher<View>): Matcher<View> {
    val matcher = FindViewByIdMatcher(R.id.snackbar_text, notNullValue(View::class.java))
    return if (matchers.isEmpty()) {
        matcher
    } else {
        allOf(listOf(matcher, *matchers))
    }
}

/**
 * Creates matcher that matches snackbar message text with given string resource id.
 */
fun withMessage(@StringRes resId: Int): Matcher<View> =
    FindViewByIdMatcher(R.id.snackbar_text, withText(resId))

/**
 * Creates matcher that matches snackbar action button text with given string resource id.
 */
fun withAction(@StringRes resId: Int): Matcher<View> =
    FindViewByIdMatcher(R.id.snackbar_action, withText(resId))

/**
 * Wraps matcher and apply it on a view with given resource id.
 */
class FindViewByIdMatcher(
    @IdRes private val viewResId: Int,
    private val viewMatcher: Matcher<View>
) : TypeSafeMatcher<View>() {

    override fun matchesSafely(item: View): Boolean {
        val view = item.findViewById<View>(viewResId)
        return viewMatcher.matches(view)
    }

    override fun describeTo(description: Description) {
        viewMatcher.describeTo(description)
    }

    override fun describeMismatchSafely(item: View, mismatchDescription: Description) {
        val view = item.findViewById<View>(viewResId)
        if (view == null) {
            mismatchDescription.appendText("No views in hierarchy found with id: ")
                .appendValue(resourceName(item.resources, viewResId))
        } else {
            mismatchDescription.appendText("was ")
                .appendValue(describe(view))
        }
    }

    private fun resourceName(resources: Resources, @IdRes resId: Int): String {
        return try {
            resources.getResourceName(resId)
        } catch (e: Resources.NotFoundException) {
            String.format("%s (resource name not found)", resId)
        }
    }
}
