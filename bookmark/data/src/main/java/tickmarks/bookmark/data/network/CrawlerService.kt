package tickmarks.bookmark.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Retrofit service interface for crawling web pages.
 */
internal interface CrawlerService {

    /**
     * Crawls web page elements of given url.
     */
    @GET
    fun crawl(@Url url: String): Single<WebPageElementsRaw>
}