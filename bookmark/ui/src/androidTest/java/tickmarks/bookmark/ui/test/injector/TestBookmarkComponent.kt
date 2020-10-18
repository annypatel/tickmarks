package tickmarks.bookmark.ui.test.injector

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import tickmarks.base.data.injector.NetworkModule
import tickmarks.base.ui.injector.ViewModelFactoryModule
import tickmarks.bookmark.data.injector.BookmarkDataModule
import tickmarks.bookmark.domain.injector.BookmarkDomainModule
import tickmarks.bookmark.ui.injector.BookmarkUiModule
import tickmarks.bookmark.ui.test.TestBookmarkApp
import tickmarks.test.ui.injector.TestRxSchedulersModule
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
        TestRxSchedulersModule::class,
        TestBookmarkAppModule::class,
        // feature modules
        BookmarkUiModule::class,
        BookmarkDomainModule::class,
        BookmarkDataModule::class
    ]
)
interface TestBookmarkComponent : AndroidInjector<TestBookmarkApp> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<TestBookmarkApp>
}
