package tickmarks.ui

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import tickmarks.ui.rx.UiSchedulers
import javax.inject.Singleton

/**
 * Dagger [module][Module] for base <code>ui</code> module that declares the dependencies to be bind into application
 * level object graph.
 */
@Module
object BaseUiModule {

    @Provides
    @Singleton
    @JvmStatic
    fun uiSchedulers() = UiSchedulers(
        mainThread = AndroidSchedulers.mainThread()
    )
}