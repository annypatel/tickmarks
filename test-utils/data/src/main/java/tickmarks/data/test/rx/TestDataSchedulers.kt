package tickmarks.data.test.rx

import io.reactivex.schedulers.Schedulers
import tickmarks.data.rx.DataSchedulers

/**
 * [DataSchedulers] for unit tests.
 */
val testDataSchedulers = object : DataSchedulers {
    override val io = Schedulers.trampoline()
    override val database = Schedulers.trampoline()
}
