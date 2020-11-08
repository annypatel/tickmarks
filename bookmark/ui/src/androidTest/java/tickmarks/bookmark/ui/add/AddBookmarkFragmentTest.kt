package tickmarks.bookmark.ui.add

import dagger.hilt.android.testing.BindValueIntoSet
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import okreplay.OkReplay
import org.junit.Rule
import org.junit.Test
import tickmarks.base.ui.injector.RxSchedulersModule
import tickmarks.bookmark.ui.R
import tickmarks.test.ui.OkReplayRule

@HiltAndroidTest
@UninstallModules(RxSchedulersModule::class)
class AddBookmarkFragmentTest {

    @get:Rule(order = 0) val hilt = HiltAndroidRule(this)
    @get:Rule(order = 1) val okReplay = OkReplayRule(this)
    @BindValueIntoSet @JvmField val interceptor = okReplay.interceptor

    @Test
    fun addBookmark_givenEmptyUrl_shouldShowEmptyError() = addBookmark {
        launch()
        typeUrl("")

        clickAddBookmark()

        shouldShowMessage(R.string.add_bookmark_empty_url)
    }

    @Test
    @OkReplay
    fun addBookmark_whenSuccessful_shouldShowSuccessMessage() = addBookmark {
        launch()
        typeUrl("https://www.example.com")

        clickAddBookmark()

        shouldShowMessage(R.string.add_bookmark_successful)
    }

    @Test
    @OkReplay
    fun addBookmark_whenFailed_shouldShowFailureMessage() = addBookmark {
        launch()
        typeUrl("https://www.example.com")

        clickAddBookmark()

        shouldShowMessage(R.string.add_bookmark_failure)
    }
}
