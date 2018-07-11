package tickmarks.bookmark.data

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tickmarks.bookmark.data.network.CrawlerService
import tickmarks.bookmark.data.network.WebPageElementsRaw
import tickmarks.bookmark.domain.WebPageElements
import tickmarks.data.test.rx.testDataSchedulers

class CrawlerRepositoryImplTest {

    @Mock
    private lateinit var crawlerService: CrawlerService
    private lateinit var crawlerRepository: CrawlerRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        crawlerRepository = CrawlerRepositoryImpl(testDataSchedulers(), crawlerService)
    }

    @Test
    fun crawl_whenCrawlingSuccessful_shouldEmitAndComplete() {
        val elements = WebPageElementsRaw("Title", "Url", "Image", "Description")
        val expectedElements = WebPageElements(elements.title, elements.url, elements.image, elements.description)
        whenever(crawlerService.crawl(any()))
            .thenReturn(Single.just(elements))

        val observer = crawlerRepository.crawl("http://www.example.com")
            .test()

        observer.assertValue(expectedElements)
            .assertComplete()
            .assertNoErrors()
    }

    @Test
    fun crawl_whenCrawlingFailed_shouldError() {
        val expectedError = RuntimeException()
        whenever(crawlerService.crawl(any()))
            .thenReturn(Single.error(expectedError))

        val observer = crawlerRepository.crawl("http://www.example.com")
            .test()

        observer.assertNoValues()
            .assertNotComplete()
            .assertError(expectedError)
    }
}