package tickmarks.bookmark.ui.add

import androidx.databinding.Bindable
import tickmarks.bookmark.ui.BR
import tickmarks.ui.binding.EMPTY
import tickmarks.ui.binding.NONE
import tickmarks.ui.binding.Visibility
import tickmarks.ui.binding.bind
import tickmarks.ui.event.Event
import tickmarks.ui.viewmodel.BaseViewState

/**
 * View State for Add Bookmark screen.
 */
class AddBookmarkViewState : BaseViewState() {
    @get:Bindable var url by bind(BR.url, EMPTY)
    @get:Bindable var error by bind(BR.error, NONE)
    @get:Bindable var loader by bind(BR.loader, Visibility.GONE)
    @get:Bindable var snackbar by bind(BR.snackbar, Event(NONE))
}