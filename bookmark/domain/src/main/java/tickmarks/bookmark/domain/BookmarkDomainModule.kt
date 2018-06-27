package tickmarks.bookmark.domain

import dagger.Binds
import dagger.Module

/**
 * Dagger [module][Module] for bookmark domain module.
 */
@Module
abstract class BookmarkDomainModule {

    @Binds
    internal abstract fun addBookmark(addBookmark: AddBookmarkImpl): AddBookmark
}