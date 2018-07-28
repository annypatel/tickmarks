package tickmarks.bookmark.ui.test.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import tickmarks.bookmark.di.BookmarkModule
import tickmarks.bookmark.ui.test.TestBookmarkApp
import tickmarks.data.network.di.NetworkModule
import tickmarks.ui.test.di.TestSchedulersModule
import tickmarks.ui.viewmodel.di.ViewModelFactoryModule
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

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TestBookmarkApp>()
}