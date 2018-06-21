package tickmarks.data.rx

import io.reactivex.Scheduler

/**
 * RxJava schedulers for data modules. Use these schedulers to perform network/disk IO or database related operations
 * in your repository implementations.
 */
class DataSchedulers(
    val io: Scheduler,
    val database: Scheduler
)