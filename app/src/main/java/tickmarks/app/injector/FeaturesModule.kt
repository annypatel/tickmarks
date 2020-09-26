package tickmarks.app.injector

import dagger.Module
import tickmarks.bookmark.ui.injector.BookmarkModule

/**
 * Defines all feature modules of this application.
 */
@Module(
    includes = [
        BookmarkModule::class
    ]
)
object FeaturesModule
