package tickmarks.bookmark.ui

import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import tickmarks.bookmark.data.BookmarkDataModule
import tickmarks.bookmark.domain.BookmarkDomainModule
import tickmarks.bookmark.ui.add.AddBookmarkFragment

/**
 * Dagger [module][Module] for bookmark module, binds [AndroidInjector] for fragments/activities into application
 * object graph.
 */
@Module
abstract class BookmarkModule {

    @ContributesAndroidInjector(
        modules = [
            BookmarkUiModule::class,
            BookmarkDomainModule::class,
            BookmarkDataModule::class
        ]
    )
    abstract fun addBookmarkFragment(): AddBookmarkFragment
}