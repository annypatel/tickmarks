package tickmarks.ui

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import tickmarks.ui.rx.UiSchedulers
import tickmarks.ui.viewmodel.ViewModelFactory
import javax.inject.Singleton

/**
 * Dagger [module][Module] for base <code>ui</code> module that declares the dependencies to be bind into application
 * level object graph.
 */
@Module
abstract class BaseUiModule {

    @Binds
    abstract fun viewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun uiSchedulers() = UiSchedulers(
            mainThread = AndroidSchedulers.mainThread()
        )
    }
}