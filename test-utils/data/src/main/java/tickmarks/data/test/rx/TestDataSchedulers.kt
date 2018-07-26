package tickmarks.data.test.rx

import io.reactivex.schedulers.Schedulers
import tickmarks.data.rx.DataSchedulers

/**
 * Creates [DataSchedulers] for unit tests.
 */
fun testDataSchedulers() = DataSchedulers(
    io = Schedulers.trampoline(),
    database = Schedulers.trampoline()
)