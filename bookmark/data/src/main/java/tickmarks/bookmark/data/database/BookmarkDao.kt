package tickmarks.bookmark.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Completable.fromAction
import io.reactivex.Single

/**
 * Data Access Object for the bookmarks table.
 */
@Dao
abstract class BookmarkDao {

    /**
     * Inserts a bookmark in the database.
     *
     * @param bookmark The bookmark to be inserted.
     */
    open fun insert(bookmark: BookmarkEntity): Completable = fromAction {
        insertImpl(bookmark)
    }

    @Insert
    protected abstract fun insertImpl(bookmark: BookmarkEntity)

    /**
     * To get all bookmarks.
     */
    @Query("SELECT * FROM bookmarks")
    abstract fun getAll(): Single<List<BookmarkEntity>>
}