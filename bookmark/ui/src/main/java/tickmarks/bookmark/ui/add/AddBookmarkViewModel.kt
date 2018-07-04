package tickmarks.bookmark.ui.add

import androidx.databinding.ObservableField
import io.reactivex.rxkotlin.subscribeBy
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.ui.R
import tickmarks.ui.binding.NONE
import tickmarks.ui.binding.Visibility
import tickmarks.ui.binding.Visibility.GONE
import tickmarks.ui.binding.Visibility.VISIBLE
import tickmarks.ui.liveevent.MutableLiveEvent
import tickmarks.ui.rx.UiSchedulers
import tickmarks.ui.viewmodel.RxViewModel
import javax.inject.Inject

/**
 * View Model for Add Bookmark screen.
 */
internal class AddBookmarkViewModel @Inject constructor(
    private val schedulers: UiSchedulers,
    private val addBookmark: AddBookmark
) : RxViewModel() {

    val snackbar = MutableLiveEvent<Int>()
    val url = ObservableField<String>()
    val error = ObservableField<Int>(NONE)
    val loader = ObservableField<Visibility>(GONE)

    fun addBookmark() {
        val urlToAdd = url.get()
        if (urlToAdd.isNullOrEmpty()) {
            error.set(R.string.add_bookmark_empty_url)
            return
        }

        error.set(NONE)
        loader.set(VISIBLE)
        addBookmark.execute(urlToAdd!!)
            .observeOn(schedulers.mainThread)
            .subscribeBy(
                onComplete = {
                    loader.set(GONE)
                    snackbar.set(R.string.add_bookmark_successful)
                },
                onError = {
                    loader.set(GONE)
                    snackbar.set(R.string.add_bookmark_failure)
                }
            )
            .autoDispose()
    }
}