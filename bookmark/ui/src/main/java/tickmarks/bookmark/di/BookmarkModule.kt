package tickmarks.bookmark.di

import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import tickmarks.bookmark.data.database.di.BookmarkDatabaseModule
import tickmarks.bookmark.data.di.BookmarkDataModule
import tickmarks.bookmark.domain.di.BookmarkDomainModule
import tickmarks.bookmark.ui.add.AddBookmarkFragment
import tickmarks.bookmark.ui.di.BookmarkUiModule

/**
 * Dagger [module][Module] for bookmark module, binds [AndroidInjector] for fragments/activities and bookmark database
 * instance into application object graph.
 */
@Module(includes = [BookmarkDatabaseModule::class])
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