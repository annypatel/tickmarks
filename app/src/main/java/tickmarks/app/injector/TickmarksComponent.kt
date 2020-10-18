package tickmarks.app.injector

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import tickmarks.app.TickmarksApp
import tickmarks.base.data.injector.NetworkModule
import tickmarks.base.ui.injector.RxSchedulersModule
import tickmarks.base.ui.injector.ViewModelFactoryModule
import javax.inject.Singleton

/**
 * The dagger component for the app, manages application level dependencies, annotated as singleton and
 * [TickmarksApp] will ensure that only one instance of the class is created.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        RxSchedulersModule::class,
        AppModule::class,
        FeaturesModule::class
    ]
)
interface TickmarksComponent : AndroidInjector<TickmarksApp> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<TickmarksApp>
}
