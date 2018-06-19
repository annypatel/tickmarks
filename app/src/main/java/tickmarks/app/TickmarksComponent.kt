package tickmarks.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * The dagger component for the app, manages application level dependencies, annotated as singleton and
 * {@link TickmarksApp} will ensure that only one instance of the class is created.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class
    ]
)
interface TickmarksComponent : AndroidInjector<TickmarksApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TickmarksApp>()
}