package tickmarks.bookmark.ui.add

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import tickmarks.bookmark.ui.R
import tickmarks.test.ui.mockserver.setBodyAsset

class AddBookmarkFragmentTest {

    @get:Rule
    var server = MockWebServer()

    @Test
    fun addBookmark_givenEmptyUrl_shouldShowEmptyError() {
        launchActivity<AddBookmarkActivity>()
        onView(withId(R.id.etUrl))
            .perform(typeText(""))

        onView(withId(R.id.btnAddBookmark))
            .perform(click(), closeSoftKeyboard())

        onView(withText(R.string.add_bookmark_empty_url))
            .check(matches(isDisplayed()))
    }

    @Test
    fun addBookmark_whenSuccessful_shouldShowSuccessMessage() {
        server.enqueue(MockResponse().setBodyAsset("open_graph_props.html"))
        launchActivity<AddBookmarkActivity>()
        val urlToBookmark = server.url("/").toString()
        onView(withId(R.id.etUrl))
            .perform(typeText(urlToBookmark))

        onView(withId(R.id.btnAddBookmark))
            .perform(click(), closeSoftKeyboard())

        onView(withText(R.string.add_bookmark_successful))
            .check(matches(isDisplayed()))
    }

    @Test
    fun addBookmark_whenFailed_shouldShowFailureMessage() {
        server.enqueue(MockResponse().setResponseCode(404))
        launchActivity<AddBookmarkActivity>()
        val urlToBookmark = server.url("/").toString()
        onView(withId(R.id.etUrl))
            .perform(typeText(urlToBookmark))

        onView(withId(R.id.btnAddBookmark))
            .perform(click(), closeSoftKeyboard())

        onView(withText(R.string.add_bookmark_failure))
            .check(matches(isDisplayed()))
    }
}
