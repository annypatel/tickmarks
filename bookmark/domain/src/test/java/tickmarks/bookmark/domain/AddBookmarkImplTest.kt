package tickmarks.bookmark.domain

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Test
import tickmarks.test.domain.rx.testDomainSchedulers

class AddBookmarkImplTest {

    private val crawlerRepository = mock<CrawlerRepository>()
    private val bookmarkRepository = mock<BookmarkRepository>()
    private val addBookmark = AddBookmarkImpl(testDomainSchedulers, crawlerRepository, bookmarkRepository)

    @Test
    fun execute_whenCrawlingAndSavingSuccessful_shouldComplete() {
        whenever(crawlerRepository.crawl(any()))
            .thenReturn(Single.just(stubWebPageElements()))
        whenever(bookmarkRepository.saveBookmark(any()))
            .thenReturn(Completable.complete())

        val observer = addBookmark("http://www.example.com")
            .test()

        observer.assertComplete()
            .assertNoErrors()
    }

    @Test
    fun execute_whenSavingFailed_shouldError() {
        whenever(crawlerRepository.crawl(any()))
            .thenReturn(Single.just(stubWebPageElements()))
        val expectedError = RuntimeException()
        whenever(bookmarkRepository.saveBookmark(any()))
            .thenReturn(Completable.error(expectedError))

        val observer = addBookmark("http://www.example.com")
            .test()

        observer.assertNotComplete()
            .assertError(expectedError)
    }

    @Test
    fun execute_whenCrawlingFailed_shouldError() {
        val expectedError = RuntimeException()
        whenever(crawlerRepository.crawl(any()))
            .thenReturn(Single.error(expectedError))

        val observer = addBookmark("http://www.example.com")
            .test()

        observer.assertNotComplete()
            .assertError(expectedError)
    }

    private fun stubWebPageElements() =
        WebPageElements("Title", "Url", "Image", "Description")
}
