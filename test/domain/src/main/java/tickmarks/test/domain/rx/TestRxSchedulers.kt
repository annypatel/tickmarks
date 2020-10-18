package tickmarks.test.domain.rx

import io.reactivex.schedulers.Schedulers
import tickmarks.base.domain.rx.RxSchedulers

/**
 * [RxSchedulers] for unit tests.
 */
val testSchedulers = RxSchedulers(
    main = Schedulers.trampoline(),
    io = Schedulers.trampoline(),
    computation = Schedulers.trampoline(),
    database = Schedulers.trampoline()
)
