package tickmarks.bookmark.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import tickmarks.bookmark.data.CrawlerRepositoryImpl
import tickmarks.bookmark.data.network.CrawlerService
import tickmarks.bookmark.domain.CrawlerRepository
import tickmarks.data.network.NetworkClient

/**
 * Dagger [module][Module] for bookmark data module.
 */
@Module
abstract class BookmarkDataModule {

    @Binds
    internal abstract fun crawlerRepository(repository: CrawlerRepositoryImpl): CrawlerRepository

    @Module
    internal companion object {

        @Provides
        @JvmStatic
        fun crawlerService(client: NetworkClient): CrawlerService {
            return client.create(CrawlerService::class)
        }
    }
}