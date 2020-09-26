package tickmarks.bookmark.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A bookmark entity for bookmarks table in database.
 */
@Entity(tableName = "bookmarks")
data class BookmarkEntity(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "image")
    val image: String?,

    @ColumnInfo(name = "description")
    val description: String?
)
