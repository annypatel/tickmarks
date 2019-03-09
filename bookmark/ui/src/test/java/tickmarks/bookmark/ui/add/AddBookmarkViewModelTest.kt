package tickmarks.bookmark.ui.add

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.ui.R
import tickmarks.ui.binding.NONE
import tickmarks.ui.binding.Visibility.GONE
import tickmarks.ui.test.rx.testUiSchedulers
import org.hamcrest.CoreMatchers.equalTo

class AddBookmarkViewModelTest {

    @Mock
    private lateinit var addBookmark: AddBookmark
    private lateinit var viewModel: AddBookmarkViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = AddBookmarkViewModel(testUiSchedulers, addBookmark)
    }

    @Test
    fun addBookmark_givenEmptyUrl_shouldSetError() {
        viewModel.url = ""

        viewModel.addBookmark()

        assertThat(viewModel.error, equalTo(R.string.add_bookmark_empty_url))
    }

    @Test
    fun addBookmark_addBookmarkSuccessful_shouldSetSuccessMessage() {
        whenever(addBookmark(any())).thenReturn(Completable.complete())
        viewModel.url = "http://example.com"

        viewModel.addBookmark()

        assertThat(viewModel.error, equalTo(NONE))
        assertThat(viewModel.loader, equalTo(GONE))
        assertThat(viewModel.snackbar.data, equalTo(R.string.add_bookmark_successful))
    }

    @Test
    fun addBookmark_addBookmarkFailed_shouldSetFailureMessage() {
        whenever(addBookmark(any())).thenReturn(Completable.error(RuntimeException()))
        viewModel.url = "http://example.com"

        viewModel.addBookmark()

        assertThat(viewModel.error, equalTo(NONE))
        assertThat(viewModel.loader, equalTo(GONE))
        assertThat(viewModel.snackbar.data, equalTo(R.string.add_bookmark_failure))
    }
}