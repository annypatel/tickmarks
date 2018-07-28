package tickmarks.app.di

import android.app.Application
import dagger.Binds
import dagger.Module
import tickmarks.app.TickmarksApp

/**
 * Dagger [module][Module] that binds [TickmarksApp] as [Application] into application level object graph.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun application(app: TickmarksApp): Application
}