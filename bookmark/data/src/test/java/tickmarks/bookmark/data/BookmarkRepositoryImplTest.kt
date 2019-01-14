package tickmarks.bookmark.data

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tickmarks.bookmark.data.database.BookmarkDao
import tickmarks.bookmark.domain.Bookmark
import tickmarks.data.test.rx.testDataSchedulers

class BookmarkRepositoryImplTest {

    @Mock
    private lateinit var bookmarkDao: BookmarkDao
    private lateinit var repository: BookmarkRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = BookmarkRepositoryImpl(testDataSchedulers, bookmarkDao)
    }

    @Test
    fun saveBookmark_whenInsertSuccessful_shouldComplete() {
        whenever(bookmarkDao.insert(any()))
            .thenReturn(Completable.complete())

        val observer = repository.saveBookmark(stubBookmark())
            .test()

        observer.assertComplete()
            .assertNoErrors()
    }

    @Test
    fun saveBookmark_whenInsertFailed_shouldError() {
        val expectedError = RuntimeException()
        whenever(bookmarkDao.insert(any()))
            .thenReturn(Completable.error(expectedError))

        val observer = repository.saveBookmark(stubBookmark())
            .test()

        observer.assertNotComplete()
            .assertError(expectedError)
    }

    private fun stubBookmark() = Bookmark(
        title = "Title",
        url = "Url",
        image = "Image",
        description = "Description"
    )
}