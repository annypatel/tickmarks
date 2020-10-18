package tickmarks.bookmark.ui.add

import io.reactivex.rxkotlin.subscribeBy
import tickmarks.base.domain.rx.RxSchedulers
import tickmarks.base.ui.binding.NONE
import tickmarks.base.ui.binding.Visibility.GONE
import tickmarks.base.ui.binding.Visibility.VISIBLE
import tickmarks.base.ui.event.Event
import tickmarks.base.ui.viewmodel.BaseViewModel
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.ui.R
import javax.inject.Inject

/**
 * View Model for Add Bookmark screen.
 */
internal class AddBookmarkViewModel @Inject constructor(
    private val schedulers: RxSchedulers,
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
            .observeOn(schedulers.main)
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
