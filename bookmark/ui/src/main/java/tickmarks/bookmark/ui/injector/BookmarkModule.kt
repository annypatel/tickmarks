package tickmarks.bookmark.ui.injector

import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import tickmarks.bookmark.data.injector.BookmarkDataModule
import tickmarks.bookmark.data.injector.BookmarkDatabaseModule
import tickmarks.bookmark.domain.injector.BookmarkDomainModule
import tickmarks.bookmark.ui.add.AddBookmarkFragment

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
