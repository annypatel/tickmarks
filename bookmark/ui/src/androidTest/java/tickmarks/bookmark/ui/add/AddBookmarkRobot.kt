package tickmarks.bookmark.ui.add

import androidx.annotation.StringRes
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import tickmarks.bookmark.ui.R

fun addBookmark(init: AddBookmarkRobot.() -> Unit) = AddBookmarkRobot().init()

class AddBookmarkRobot {

    fun launch() {
        launchActivity<AddBookmarkActivity>()
    }

    fun typeUrl(url: String) {
        onView(withId(R.id.etUrl))
            .perform(typeText(url))
    }

    fun clickAddBookmark() {
        onView(withId(R.id.btnAddBookmark))
            .perform(click(), closeSoftKeyboard())
    }

    fun shouldShowMessage(@StringRes msgResId: Int) {
        onView(withText(msgResId))
            .check(matches(isDisplayed()))
    }
}
