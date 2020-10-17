package tickmarks.bookmark.domain

import io.reactivex.Completable
import tickmarks.base.domain.rx.CompletableUseCase
import tickmarks.base.domain.rx.DomainSchedulers
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
    private val crawlerRepository: CrawlerRepository,
    private val bookmarkRepository: BookmarkRepository
) : AddBookmark {

    override fun invoke(input: String): Completable {
        return crawlerRepository.crawl(input)
            .observeOn(schedulers.computation)
            .map {
                Bookmark(
                    it.title,
                    it.url ?: input,
                    it.image,
                    it.description
                )
            }
            .flatMapCompletable {
                bookmarkRepository.saveBookmark(it)
            }
    }
}
