package tickmarks.bookmark.domain

import io.reactivex.Completable

/**
 * Repository for managing bookmarks.
 */
interface BookmarkRepository {

    /**
     * To save a bookmark.
     *
     * @param bookmark The bookmark to be saved.
     */
    fun saveBookmark(bookmark: Bookmark): Completable
}
