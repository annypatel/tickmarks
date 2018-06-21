package tickmarks.domain

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import tickmarks.domain.rx.DomainSchedulers
import javax.inject.Singleton

/**
 * Dagger [module][Module] for base domain module that declares the dependencies to be bind into application level
 * object graph.
 */
@Module
object BaseDomainModule {

    @Provides
    @Singleton
    @JvmStatic
    fun domainSchedulers() = DomainSchedulers(
        computation = Schedulers.computation()
    )
}