package tickmarks.bookmark.ui.test.di

import android.app.Application
import dagger.Binds
import dagger.Module
import tickmarks.bookmark.ui.test.TestBookmarkApp

/**
 * Dagger [module][Module] that binds [TestBookmarkApp] as [Application] into application level object graph.
 */
@Module
abstract class TestBookmarkAppModule {

    @Binds
    abstract fun application(app: TestBookmarkApp): Application
}