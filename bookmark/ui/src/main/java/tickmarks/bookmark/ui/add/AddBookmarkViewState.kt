package tickmarks.bookmark.ui.add

import androidx.databinding.Bindable
import tickmarks.base.ui.binding.EMPTY
import tickmarks.base.ui.binding.NONE
import tickmarks.base.ui.binding.Visibility
import tickmarks.base.ui.binding.bind
import tickmarks.base.ui.event.Event
import tickmarks.base.ui.viewmodel.BaseViewState
import tickmarks.bookmark.ui.BR

/**
 * View State for Add Bookmark screen.
 */
class AddBookmarkViewState : BaseViewState() {
    @get:Bindable var url by bind(BR.url, EMPTY)
    @get:Bindable var error by bind(BR.error, NONE)
    @get:Bindable var loader by bind(BR.loader, Visibility.GONE)
    @get:Bindable var snackbar by bind(BR.snackbar, Event(NONE))
}
