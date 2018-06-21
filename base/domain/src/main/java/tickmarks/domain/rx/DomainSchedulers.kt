package tickmarks.domain.rx

import io.reactivex.Scheduler
import tickmarks.domain.UseCase0
import tickmarks.domain.UseCase1

/**
 * RxJava schedulers for domain modules. Use these schedulers to perform business logic related operations in your
 * [UseCase0] or [UseCase1] implementations.
 */
class DomainSchedulers(
    val computation: Scheduler
)