package tickmarks.ui.rx

import io.reactivex.schedulers.Schedulers

/**
 * Creates [UiSchedulers] for unit tests.
 */
fun testUiSchedulers() = UiSchedulers(
    mainThread = Schedulers.trampoline()
)