package tickmarks.bookmark.domain

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tickmarks.domain.test.rx.testDomainSchedulers

class AddBookmarkImplTest {

    @Mock
    private lateinit var crawlerRepository: CrawlerRepository
    private lateinit var addBookmark: AddBookmarkImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        addBookmark = AddBookmarkImpl(testDomainSchedulers(), crawlerRepository)
    }

    @Test
    fun execute_whenCrawlingSuccessful_shouldComplete() {
        whenever(crawlerRepository.crawl(any()))
            .thenReturn(Single.just(stubWebPageElements()))

        val observer = addBookmark("http://www.example.com")
            .test()

        observer.assertComplete()
            .assertNoErrors()
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