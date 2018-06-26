package tickmarks.domain.rx

import io.reactivex.schedulers.Schedulers

/**
 * Creates [DomainSchedulers] for unit tests.
 */
fun testDomainSchedulers() = DomainSchedulers(
    computation = Schedulers.trampoline()
)