package tickmarks.bookmark.domain

import io.reactivex.Single

/**
 * Repository for crawling html pages.
 */
interface CrawlerRepository {

    /**
     * Fetches html page elements for given url.
     */
    fun crawl(url: String): Single<WebPageElements>
}
