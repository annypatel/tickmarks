package tickmarks.base.ui.injector

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import tickmarks.base.ui.viewmodel.ViewModelFactory

/**
 * Dagger [module][Module] for ViewModel factory that declares [ViewModelProvider.Factory] to be bind into application
 * level object graph.
 */
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
