package tickmarks.bookmark.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Data Access Object for the bookmarks table.
 */
@Dao
interface BookmarkDao {

    /**
     * Inserts a bookmark in the database.
     *
     * @param bookmark The bookmark to be inserted.
     */
    @Insert
    fun insert(bookmark: BookmarkEntity): Completable

    /**
     * To get all bookmarks.
     */
    @Query("SELECT * FROM bookmarks")
    fun getAll(): Single<List<BookmarkEntity>>
}