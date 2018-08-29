package tickmarks.bookmark.domain

import io.reactivex.Completable
import tickmarks.domain.rx.CompletableUseCase
import tickmarks.domain.rx.DomainSchedulers
import javax.inject.Inject

/**
 * Use case for adding a bookmark, takes web page url as input.
 */
interface AddBookmark : CompletableUseCase<String>

/**
 * Internal implementation of AddBookmark use case.
 */
internal class AddBookmarkImpl @Inject constructor(
    private val schedulers: DomainSchedulers,
    private val crawlerRepository: CrawlerRepository
) : AddBookmark {

    override fun execute(input: String): Completable {
        return crawlerRepository.crawl(input)
            .observeOn(schedulers.computation)
            .ignoreElement()
    }
}