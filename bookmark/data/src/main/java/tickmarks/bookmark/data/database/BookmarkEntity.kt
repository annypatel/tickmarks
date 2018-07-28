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
    var id: Long,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "image")
    val image: String?,

    @ColumnInfo(name = "description")
    val description: String?
)