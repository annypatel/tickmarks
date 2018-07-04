package tickmarks.app

import dagger.Module
import tickmarks.bookmark.ui.BookmarkModule

/**
 * Defines all feature modules of this application.
 */
@Module(
    includes = [
        BookmarkModule::class
    ]
)
object FeatureModules