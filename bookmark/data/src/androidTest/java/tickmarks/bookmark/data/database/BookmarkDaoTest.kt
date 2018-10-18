package tickmarks.bookmark.data.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as IS

class BookmarkDaoTest {

    private lateinit var database: BookmarkDatabase
    private lateinit var bookmarkDao: BookmarkDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(getApplicationContext(), BookmarkDatabase::class.java)
            .build()
        bookmarkDao = database.bookmarkDao()
    }

    @After
    fun cleanup() {
        database.close()
    }

    @Test
    fun insert_savesBookmark() {
        val expectedBookmark = stubBookmark()

        val observer = bookmarkDao.insert(expectedBookmark)
            .test()

        observer.assertComplete()
            .assertNoErrors()
        val actualBookmark = bookmarkDao.getAll()
            .test()
            .values()[0][0]
        assertThat(actualBookmark, IS(expectedBookmark))
    }

    private fun stubBookmark() = BookmarkEntity(
        id = 100,
        title = "Title",
        url = "Url",
        image = "Image",
        description = "Description"
    )
}