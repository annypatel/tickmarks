package tickmarks.bookmark.data

import io.reactivex.Single
import tickmarks.base.data.rx.DataSchedulers
import tickmarks.bookmark.data.network.CrawlerService
import tickmarks.bookmark.domain.CrawlerRepository
import tickmarks.bookmark.domain.WebPageElements
import javax.inject.Inject

/**
 * Internal implementation of [CrawlerRepository], fetches web pages using [CrawlerService].
 */
internal class CrawlerRepositoryImpl @Inject constructor(
    private val schedulers: DataSchedulers,
    private val crawlerService: CrawlerService
) : CrawlerRepository {

    override fun crawl(url: String): Single<WebPageElements> {
        return crawlerService.crawl(url)
            .subscribeOn(schedulers.io)
            .map {
                WebPageElements(
                    it.title,
                    it.url,
                    it.image,
                    it.description
                )
            }
    }
}
