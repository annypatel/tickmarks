package tickmarks.test.ui.rx

import io.reactivex.schedulers.Schedulers
import tickmarks.base.ui.rx.UiSchedulers

/**
 * [UiSchedulers] for unit tests.
 */
val testUiSchedulers = object : UiSchedulers {
    override val mainThread = Schedulers.trampoline()
}
