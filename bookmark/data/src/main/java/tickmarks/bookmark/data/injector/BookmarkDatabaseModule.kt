package tickmarks.bookmark.data.injector

import dagger.Module
import dagger.Provides
import tickmarks.bookmark.data.database.BookmarkDatabase
import javax.inject.Singleton

/**
 * Dagger module for exposing [BookmarkDatabase] to application object graph.
 */
@Module(subcomponents = [BookmarkDatabaseComponent::class])
object BookmarkDatabaseModule {

    @Provides
    @Singleton
    internal fun bookmarkDatabase(factory: BookmarkDatabaseComponent.Factory): BookmarkDatabase =
        factory.create().bookmarkDatabase()
}
