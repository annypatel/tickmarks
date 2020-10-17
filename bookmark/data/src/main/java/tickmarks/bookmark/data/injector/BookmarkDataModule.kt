package tickmarks.bookmark.data.injector

import dagger.Binds
import dagger.Module
import dagger.Provides
import tickmarks.base.data.network.NetworkClient
import tickmarks.bookmark.data.BookmarkRepositoryImpl
import tickmarks.bookmark.data.CrawlerRepositoryImpl
import tickmarks.bookmark.data.database.BookmarkDao
import tickmarks.bookmark.data.database.BookmarkDatabase
import tickmarks.bookmark.data.network.CrawlerService
import tickmarks.bookmark.domain.BookmarkRepository
import tickmarks.bookmark.domain.CrawlerRepository

/**
 * Dagger [module][Module] for bookmark data module.
 */
@Module
abstract class BookmarkDataModule {

    @Binds
    internal abstract fun crawlerRepository(repository: CrawlerRepositoryImpl): CrawlerRepository

    @Binds
    internal abstract fun bookmarkRepository(repository: BookmarkRepositoryImpl): BookmarkRepository

    @Module
    internal companion object {

        @Provides
        @JvmStatic
        fun crawlerService(client: NetworkClient): CrawlerService =
            client.create(CrawlerService::class)

        @Provides
        @JvmStatic
        fun bookmarkDao(database: BookmarkDatabase): BookmarkDao = database.bookmarkDao()
    }
}
