package tickmarks.test.ui.injector

import androidx.test.espresso.IdlingRegistry
import com.squareup.rx2.idler.Rx2Idler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tickmarks.data.rx.DataSchedulers
import tickmarks.domain.rx.DomainSchedulers
import tickmarks.ui.rx.UiSchedulers
import javax.inject.Singleton

/**
 * Dagger [module][Module] for schedulers that declares [UiSchedulers], [DomainSchedulers] and [DataSchedulers] to be
 * bind into application level object graph for integration tests.
 */
@Module
object TestSchedulersModule {

    @Provides
    @Singleton
    @JvmStatic
    fun uiSchedulers() = object : UiSchedulers {
        override val mainThread = wrap(AndroidSchedulers.mainThread(), "mainThread")
    }

    @Provides
    @Singleton
    @JvmStatic
    fun domainSchedulers() = object : DomainSchedulers {
        override val computation = wrap(Schedulers.computation(), "computation")
    }

    @Provides
    @Singleton
    @JvmStatic
    fun dataSchedulers() = object : DataSchedulers {
        override val io = wrap(Schedulers.io(), "io")
        override val database = wrap(Schedulers.single(), "database")
    }

    @JvmStatic
    private fun wrap(scheduler: Scheduler, name: String): Scheduler {
        val wrapped = Rx2Idler.wrap(scheduler, name)
        IdlingRegistry.getInstance().register(wrapped)
        return wrapped
    }
}
