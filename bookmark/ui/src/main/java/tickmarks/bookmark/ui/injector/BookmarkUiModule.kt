package tickmarks.bookmark.ui.injector

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import tickmarks.base.ui.injector.ViewModelKey
import tickmarks.bookmark.ui.add.AddBookmarkFragment
import tickmarks.bookmark.ui.add.AddBookmarkViewModel

/**
 * Dagger [module][Module] for bookmark ui module.
 */
@Module
abstract class BookmarkUiModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddBookmarkViewModel::class)
    internal abstract fun addBookmarkViewModel(viewModel: AddBookmarkViewModel): ViewModel

    @ContributesAndroidInjector
    internal abstract fun addBookmarkFragment(): AddBookmarkFragment
}
