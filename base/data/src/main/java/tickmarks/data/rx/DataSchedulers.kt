package tickmarks.data.rx

import io.reactivex.Scheduler

/**
 * RxJava schedulers for data modules. Use these schedulers to perform network/disk IO or database related operations
 * in your repository implementations.
 */
interface DataSchedulers {
    val io: Scheduler
    val database: Scheduler
}
