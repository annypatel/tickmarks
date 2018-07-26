package tickmarks.domain.test.rx

import io.reactivex.schedulers.Schedulers
import tickmarks.domain.rx.DomainSchedulers

/**
 * Creates [DomainSchedulers] for unit tests.
 */
fun testDomainSchedulers() = DomainSchedulers(
    computation = Schedulers.trampoline()
)