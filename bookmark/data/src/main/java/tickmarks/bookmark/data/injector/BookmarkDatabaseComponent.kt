package tickmarks.bookmark.data.injector

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import tickmarks.bookmark.data.database.BookmarkDatabase
import tickmarks.data.injector.PrivateToComponent

/**
 * BookmarkDatabaseComponent exposes [BookmarkDatabase] with [bookmarkDatabase] provision method, dependencies declared
 * via [Subcomponent.modules] won't exposed outside this component.
 */
@Subcomponent(modules = [InternalBookmarkDatabaseModule::class])
interface BookmarkDatabaseComponent {

    @PrivateToComponent
    fun bookmarkDatabase(): BookmarkDatabase

    @Subcomponent.Builder
    interface Builder {

        fun build(): BookmarkDatabaseComponent
    }
}

/**
 * Dagger module for [BookmarkDatabaseComponent]. Defines dependencies required to constructs [BookmarkDatabase]. All
 * the dependencies declared here is internal to [BookmarkDatabaseComponent] and won't be accessible outside.
 */
@Module
object InternalBookmarkDatabaseModule {

    @Provides
    @JvmStatic
    @PrivateToComponent
    fun bookmarkDatabase(app: Application): BookmarkDatabase {
        return Room.databaseBuilder(app, BookmarkDatabase::class.java, BookmarkDatabase.NAME)
            .build()
    }
}
