package tickmarks.base.domain.rx

import io.reactivex.Scheduler
import tickmarks.base.domain.UseCase

/**
 * RxJava schedulers for domain modules. Use these schedulers to perform business logic related operations in your
 * [UseCase] implementations.
 */
interface DomainSchedulers {
    val computation: Scheduler
}
