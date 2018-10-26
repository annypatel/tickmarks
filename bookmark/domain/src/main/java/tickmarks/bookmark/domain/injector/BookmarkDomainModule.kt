package tickmarks.bookmark.domain.injector

import dagger.Binds
import dagger.Module
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.domain.AddBookmarkImpl

/**
 * Dagger [module][Module] for bookmark domain module.
 */
@Module
abstract class BookmarkDomainModule {

    @Binds
    internal abstract fun addBookmark(addBookmark: AddBookmarkImpl): AddBookmark
}