package tickmarks.bookmark.ui.add

import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import tickmarks.bookmark.ui.R
import tickmarks.ui.binding.Visibility.INVISIBLE
import tickmarks.ui.event.Event
import tickmarks.ui.test.binding.bindNow
import tickmarks.ui.test.binding.inflate
import tickmarks.ui.test.binding.parent
import tickmarks.ui.test.equalToRes
import tickmarks.ui.test.hasSnackbar
import tickmarks.ui.test.withMessage

@RunWith(AndroidJUnit4::class)
class AddBookmarkFragmentBindingTest {

    private val binding = inflate<AddBookmarkFragmentBinding>(R.layout.fragment_add_bookmark)

    @Test
    fun bind_givenViewModel_shouldUpdateViews() {
        val viewState = AddBookmarkViewState()
        binding.viewState = viewState
        val urlToAdd = "http://www.example.com"
        val errorMsg = R.string.add_bookmark_empty_url
        val snackbarMsg = R.string.add_bookmark_failure

        binding.bindNow {
            viewState.url = urlToAdd
            viewState.error = errorMsg
            viewState.loader = INVISIBLE
            viewState.snackbar = Event(snackbarMsg)
        }

        assertThat(binding.etUrl.text.toString(), equalTo(urlToAdd))
        assertThat(binding.tilUrl.error, equalToRes(errorMsg))
        assertThat(binding.loader.visibility, equalTo(View.INVISIBLE))
        assertThat(binding.parent, hasSnackbar(withMessage(snackbarMsg)))
    }

    @Test
    fun inverseBind_givenViewModel_shouldUpdateViewModel() {
        val viewState = AddBookmarkViewState()
        binding.viewState = viewState
        val urlToAdd = "http://www.example.com"

        binding.etUrl.setText(urlToAdd)

        assertThat(viewState.url, equalTo(urlToAdd))
    }

    @Test
    fun btnAddBookmark_givenViewModel_shouldCallAddBookmark() {
        val mockedViewModel = mock<AddBookmarkViewModel>()
        binding.viewModel = mockedViewModel

        binding.btnAddBookmark.performClick()

        verify(mockedViewModel).addBookmark()
    }
}
