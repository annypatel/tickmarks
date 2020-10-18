package tickmarks.bookmark.data

import io.reactivex.Completable
import io.reactivex.Single
import tickmarks.base.domain.rx.RxSchedulers
import tickmarks.bookmark.data.database.BookmarkDao
import tickmarks.bookmark.data.database.BookmarkEntity
import tickmarks.bookmark.domain.Bookmark
import tickmarks.bookmark.domain.BookmarkRepository
import javax.inject.Inject

/**
 * Internal implementation of [BookmarkRepository], manages bookmarks in local database.
 */
internal class BookmarkRepositoryImpl @Inject constructor(
    private val schedulers: RxSchedulers,
    private val bookmarkDao: BookmarkDao
) : BookmarkRepository {

    override fun saveBookmark(bookmark: Bookmark): Completable {
        return Single.just(bookmark)
            .map {
                BookmarkEntity(
                    title = it.title,
                    url = it.url,
                    image = it.image,
                    description = it.description
                )
            }
            .flatMapCompletable {
                bookmarkDao.insert(it)
                    .subscribeOn(schedulers.database)
            }
    }
}
