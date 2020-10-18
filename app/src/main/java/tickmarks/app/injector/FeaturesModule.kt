package tickmarks.app.injector

import dagger.Module
import tickmarks.bookmark.data.injector.BookmarkDataModule
import tickmarks.bookmark.domain.injector.BookmarkDomainModule
import tickmarks.bookmark.ui.injector.BookmarkUiModule

/**
 * Defines all feature modules of this application.
 */
@Module(
    includes = [
        BookmarkUiModule::class,
        BookmarkDomainModule::class,
        BookmarkDataModule::class
    ]
)
object FeaturesModule
