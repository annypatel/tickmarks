package tickmarks.app.di

import dagger.Module
import tickmarks.bookmark.di.BookmarkModule

/**
 * Defines all feature modules of this application.
 */
@Module(
    includes = [
        BookmarkModule::class
    ]
)
object FeaturesModule