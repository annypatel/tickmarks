package tickmarks.app.injector

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tickmarks.data.rx.DataSchedulers
import tickmarks.domain.rx.DomainSchedulers
import tickmarks.ui.rx.UiSchedulers
import javax.inject.Singleton

/**
 * Dagger [module][Module] for schedulers that declares [UiSchedulers], [DomainSchedulers] and [DataSchedulers] to be
 * bind into application level object graph.
 */
@Module
object SchedulersModule {

    @Provides
    @Singleton
    @JvmStatic
    fun uiSchedulers() = UiSchedulers(
        mainThread = AndroidSchedulers.mainThread()
    )

    @Provides
    @Singleton
    @JvmStatic
    fun domainSchedulers() = DomainSchedulers(
        computation = Schedulers.computation()
    )

    @Provides
    @Singleton
    @JvmStatic
    fun dataSchedulers() = DataSchedulers(
        io = Schedulers.io(),
        database = Schedulers.single()
    )
}