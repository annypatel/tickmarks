package tickmarks.bookmark.ui.add

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.ui.R
import tickmarks.ui.binding.NONE
import tickmarks.ui.binding.Visibility.GONE
import tickmarks.ui.test.rx.testUiSchedulers
import org.hamcrest.CoreMatchers.`is` as Is

class AddBookmarkViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @Mock
    private lateinit var addBookmark: AddBookmark
    private lateinit var viewModel: AddBookmarkViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = AddBookmarkViewModel(testUiSchedulers(), addBookmark)
    }

    @Test
    fun addBookmark_givenEmptyUrl_shouldSetError() {
        viewModel.url.set("")

        viewModel.addBookmark()

        assertThat(viewModel.error.get(), Is(R.string.add_bookmark_empty_url))
    }

    @Test
    fun addBookmark_addBookmarkSuccessful_shouldSetSuccessMessage() {
        whenever(addBookmark.execute(any())).thenReturn(Completable.complete())
        viewModel.url.set("http://example.com")

        viewModel.addBookmark()

        assertThat(viewModel.error.get(), Is(NONE))
        assertThat(viewModel.loader.get(), Is(GONE))
        assertThat(viewModel.snackbar.get(), Is(R.string.add_bookmark_successful))
    }

    @Test
    fun addBookmark_addBookmarkFailed_shouldSetFailureMessage() {
        whenever(addBookmark.execute(any())).thenReturn(Completable.error(RuntimeException()))
        viewModel.url.set("http://example.com")

        viewModel.addBookmark()

        assertThat(viewModel.error.get(), Is(NONE))
        assertThat(viewModel.loader.get(), Is(GONE))
        assertThat(viewModel.snackbar.get(), Is(R.string.add_bookmark_failure))
    }
}