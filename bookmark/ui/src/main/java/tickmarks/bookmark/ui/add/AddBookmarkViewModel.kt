package tickmarks.bookmark.ui.add

import androidx.databinding.Bindable
import io.reactivex.rxkotlin.subscribeBy
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.ui.BR
import tickmarks.bookmark.ui.R
import tickmarks.ui.binding.EMPTY
import tickmarks.ui.binding.NONE
import tickmarks.ui.binding.Visibility.GONE
import tickmarks.ui.binding.Visibility.VISIBLE
import tickmarks.ui.binding.bind
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

    @get:Bindable var url by bind(BR.url, EMPTY)
    @get:Bindable var error by bind(BR.error, NONE)
    @get:Bindable var loader by bind(BR.loader, GONE)
    @get:Bindable var snackbar by bind(BR.snackbar, Event(NONE))

    fun addBookmark() {
        val urlToAdd = url
        if (urlToAdd.isEmpty()) {
            error = R.string.add_bookmark_empty_url
            return
        }

        error = NONE
        loader = VISIBLE
        addBookmark(urlToAdd)
            .observeOn(schedulers.mainThread)
            .subscribeBy(
                onComplete = {
                    loader = GONE
                    snackbar = Event(R.string.add_bookmark_successful)
                },
                onError = {
                    loader = GONE
                    snackbar = Event(R.string.add_bookmark_failure)
                }
            )
            .autoDispose()
    }
}