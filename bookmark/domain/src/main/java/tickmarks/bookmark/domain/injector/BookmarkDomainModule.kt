package tickmarks.bookmark.domain.injector

import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import tickmarks.bookmark.domain.AddBookmark
import tickmarks.bookmark.domain.AddBookmarkImpl

/**
 * Dagger [module][Module] for bookmark domain module.
 *
 * InstallIn check disabled for this module because currently Hilt does not support pure java/kotlin
 * gradle modules.
 */
@Module
@DisableInstallInCheck
abstract class BookmarkDomainModule {

    @Binds
    internal abstract fun addBookmark(addBookmark: AddBookmarkImpl): AddBookmark
}
