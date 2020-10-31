package tickmarks.test.ui.injector

import androidx.test.espresso.IdlingRegistry
import com.squareup.rx2.idler.Rx2Idler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tickmarks.base.domain.rx.RxSchedulers
import javax.inject.Singleton

/**
 * Dagger [module][Module] for declaring [RxSchedulers] to be bind into application level object
 * graph for integration tests.
 */
@Module
@InstallIn(ApplicationComponent::class)
object TestRxSchedulersModule {

    @Provides
    @Singleton
    fun rxSchedulers() = RxSchedulers(
        main = wrap(AndroidSchedulers.mainThread(), "mainThread"),
        io = wrap(Schedulers.io(), "io"),
        computation = wrap(Schedulers.computation(), "computation"),
        database = wrap(Schedulers.single(), "database")
    )

    private fun wrap(scheduler: Scheduler, name: String): Scheduler {
        val wrapped = Rx2Idler.wrap(scheduler, name)
        IdlingRegistry.getInstance().register(wrapped)
        return wrapped
    }
}
