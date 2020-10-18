package tickmarks.bookmark.data.injector

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import tickmarks.base.data.injector.PrivateToComponent
import tickmarks.bookmark.data.database.BookmarkDatabase

/**
 * BookmarkDatabaseComponent exposes [BookmarkDatabase] with [bookmarkDatabase] provision method, dependencies declared
 * via [Subcomponent.modules] won't exposed outside this component.
 */
@Subcomponent(modules = [InternalBookmarkDatabaseModule::class])
internal interface BookmarkDatabaseComponent {

    @PrivateToComponent
    fun bookmarkDatabase(): BookmarkDatabase

    @Subcomponent.Factory
    interface Factory {
        fun create(): BookmarkDatabaseComponent
    }
}

/**
 * Dagger module for [BookmarkDatabaseComponent]. Defines dependencies required to constructs [BookmarkDatabase]. All
 * the dependencies declared here is internal to [BookmarkDatabaseComponent] and won't be accessible outside.
 */
@Module
object InternalBookmarkDatabaseModule {

    @Provides
    @PrivateToComponent
    internal fun bookmarkDatabase(app: Application): BookmarkDatabase {
        return Room.databaseBuilder(app, BookmarkDatabase::class.java, BookmarkDatabase.NAME)
            .build()
    }
}
