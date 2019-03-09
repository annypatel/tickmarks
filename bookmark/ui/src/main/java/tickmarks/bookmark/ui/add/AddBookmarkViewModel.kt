package tickmarks.bookmark.ui.add

import io.reactivex.rxkotlin.subscribeBy
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.ui.R
import tickmarks.ui.binding.NONE
import tickmarks.ui.binding.Visibility.GONE
import tickmarks.ui.binding.Visibility.VISIBLE
import tickmarks.ui.event.Event
import tickmarks.ui.rx.UiSchedulers
import tickmarks.ui.viewmodel.BaseViewModel
import javax.inject.Inject

/**
 * View Model for Add Bookmark screen.
 */
internal class AddBookmarkViewModel @Inject constructor(
    private val schedulers: UiSchedulers,
    private val addBookmark: AddBookmark
) : BaseViewModel() {

    val viewState = AddBookmarkViewState()

    fun addBookmark() {
        val urlToAdd = viewState.url
        if (urlToAdd.isEmpty()) {
            viewState.error = R.string.add_bookmark_empty_url
            return
        }

        viewState.error = NONE
        viewState.loader = VISIBLE
        addBookmark(urlToAdd)
            .observeOn(schedulers.mainThread)
            .subscribeBy(
                onComplete = {
                    viewState.loader = GONE
                    viewState.snackbar = Event(R.string.add_bookmark_successful)
                },
                onError = {
                    viewState.loader = GONE
                    viewState.snackbar = Event(R.string.add_bookmark_failure)
                }
            )
            .autoDispose()
    }
}