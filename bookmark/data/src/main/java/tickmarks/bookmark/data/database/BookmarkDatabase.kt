package tickmarks.bookmark.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room database class for bookmarks database.
 */
@Database(
    version = BookmarkDatabase.VERSION,
    entities = [
        BookmarkEntity::class
    ]
)
internal abstract class BookmarkDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
        const val NAME = "bookmarks.db"
    }

    abstract fun bookmarkDao(): BookmarkDao
}
