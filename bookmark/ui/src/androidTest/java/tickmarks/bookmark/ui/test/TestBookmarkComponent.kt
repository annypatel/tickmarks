package tickmarks.bookmark.ui.test

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import tickmarks.bookmark.ui.BookmarkModule
import tickmarks.data.network.NetworkModule
import tickmarks.ui.test.rx.TestSchedulersModule
import tickmarks.ui.viewmodel.ViewModelFactoryModule
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

        TestSchedulersModule::class,
        BookmarkModule::class
    ]
)
interface TestBookmarkComponent : AndroidInjector<TestBookmarkApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TestBookmarkApp>()
}