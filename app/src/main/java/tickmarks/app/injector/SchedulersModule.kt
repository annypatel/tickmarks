package tickmarks.app.injector

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tickmarks.base.data.rx.DataSchedulers
import tickmarks.base.domain.rx.DomainSchedulers
import tickmarks.base.ui.rx.UiSchedulers
import javax.inject.Singleton

/**
 * Dagger [module][Module] for schedulers that declares [UiSchedulers], [DomainSchedulers] and [DataSchedulers] to be
 * bind into application level object graph.
 */
@Module
object SchedulersModule {

    @Provides
    @Singleton
    fun uiSchedulers() = object : UiSchedulers {
        override val mainThread = AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    fun domainSchedulers() = object : DomainSchedulers {
        override val computation = Schedulers.computation()
    }

    @Provides
    @Singleton
    fun dataSchedulers() = object : DataSchedulers {
        override val io = Schedulers.io()
        override val database = Schedulers.single()
    }
}
