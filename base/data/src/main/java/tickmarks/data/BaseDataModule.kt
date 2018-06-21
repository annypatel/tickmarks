package tickmarks.data

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import tickmarks.data.rx.DataSchedulers
import javax.inject.Singleton

/**
 * Dagger [module][Module] for base data module that declares the dependencies to be bind into application level object
 * graph.
 */
@Module
object BaseDataModule {

    @Provides
    @Singleton
    @JvmStatic
    fun dataSchedulers() = DataSchedulers(
        io = Schedulers.io(),
        database = Schedulers.single()
    )
}
