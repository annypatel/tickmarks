package tickmarks.ui.rx

import io.reactivex.Scheduler

/**
 * RxJava schedulers for ui modules. Use these schedulers to perform operations on UI thread.
 */
interface UiSchedulers {
    val mainThread: Scheduler
}
