package tickmarks.bookmark.ui.test.injector

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import tickmarks.bookmark.ui.injector.BookmarkModule
import tickmarks.bookmark.ui.test.TestBookmarkApp
import tickmarks.data.injector.NetworkModule
import tickmarks.ui.injector.ViewModelFactoryModule
import tickmarks.ui.test.injector.TestSchedulersModule
import javax.inject.Singleton

/**
 * The dagger component for the integration tests of Bookmark module, manages application level dependencies, annotated
 * as singleton and [TestBookmarkApp] will ensure that only one instance of the class is created.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        // test-only modules
        TestSchedulersModule::class,
        TestBookmarkAppModule::class,
        // feature module
        BookmarkModule::class
    ]
)
interface TestBookmarkComponent : AndroidInjector<TestBookmarkApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<TestBookmarkApp>
}