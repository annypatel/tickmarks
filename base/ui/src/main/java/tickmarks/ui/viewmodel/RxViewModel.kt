package tickmarks.ui.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * ViewModel which exposes a [CompositeDisposable] which is automatically cleared when the ViewModel is cleared.
 */
open class RxViewModel : ViewModel() {

    val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}