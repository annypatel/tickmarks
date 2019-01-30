package tickmarks.bookmark.ui.add

import android.view.View
import androidx.test.annotation.UiThreadTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import tickmarks.bookmark.ui.R
import tickmarks.ui.binding.Visibility.INVISIBLE
import tickmarks.ui.event.Event
import tickmarks.ui.test.assertThat
import tickmarks.ui.test.binding.bindNow
import tickmarks.ui.test.binding.inflate
import tickmarks.ui.test.equalToRes
import tickmarks.ui.test.hasSnackbar
import tickmarks.ui.test.withMessage

class AddBookmarkFragmentBindingTest {

    private lateinit var binding: AddBookmarkFragmentBinding

    @Before
    @UiThreadTest
    fun setup() {
        binding = inflate(R.layout.fragment_add_bookmark)
    }

    @Test
    @UiThreadTest
    fun bind_givenViewModel_shouldUpdateViews() {
        val viewModel = AddBookmarkViewModel(mock(), mock())
        binding.viewModel = viewModel
        val urlToAdd = "http://www.example.com"
        val errorMsg = R.string.add_bookmark_empty_url
        val snackbarMsg = R.string.add_bookmark_failure

        binding.bindNow {
            viewModel.url = urlToAdd
            viewModel.error = errorMsg
            viewModel.loader = INVISIBLE
            viewModel.snackbar = Event(snackbarMsg)
        }

        assertThat(binding.etUrl.text.toString(), equalTo(urlToAdd))
        assertThat(binding.tilUrl.error, equalToRes(errorMsg))
        assertThat(binding.loader.visibility, equalTo(View.INVISIBLE))
        assertThat(binding, hasSnackbar(withMessage(snackbarMsg)))
    }

    @Test
    @UiThreadTest
    fun inverseBind_givenViewModel_shouldUpdateViewModel() {
        val viewModel = AddBookmarkViewModel(mock(), mock())
        binding.viewModel = viewModel
        val urlToAdd = "http://www.example.com"

        binding.etUrl.setText(urlToAdd)

        assertThat(viewModel.url, equalTo(urlToAdd))
    }

    @Test
    @UiThreadTest
    fun btnAddBookmark_givenViewModel_shouldCallAddBookmark() {
        val mockedViewModel = mock<AddBookmarkViewModel>()
        binding.viewModel = mockedViewModel

        binding.btnAddBookmark.performClick()

        verify(mockedViewModel).addBookmark()
    }
}
