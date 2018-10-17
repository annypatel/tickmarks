package tickmarks.bookmark.domain

/**
 * Data class for a bookmark.
 */
data class Bookmark(
    val title: String?,
    val url: String,
    val image: String?,
    val description: String?
)