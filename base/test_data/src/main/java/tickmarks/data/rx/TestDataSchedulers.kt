package tickmarks.data.rx

import io.reactivex.schedulers.Schedulers

/**
 * Creates [DataSchedulers] for unit tests.
 */
fun testDataSchedulers() = DataSchedulers(
    io = Schedulers.trampoline(),
    database = Schedulers.trampoline()
)