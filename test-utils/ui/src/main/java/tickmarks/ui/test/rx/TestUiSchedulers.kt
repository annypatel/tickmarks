package tickmarks.ui.test.rx

import io.reactivex.schedulers.Schedulers
import tickmarks.ui.rx.UiSchedulers

/**
 * Creates [UiSchedulers] for unit tests.
 */
fun testUiSchedulers() = UiSchedulers(
    mainThread = Schedulers.trampoline()
)