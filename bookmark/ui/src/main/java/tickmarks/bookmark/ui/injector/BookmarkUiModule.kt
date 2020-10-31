package tickmarks.bookmark.ui.injector

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import tickmarks.bookmark.domain.injector.BookmarkDomainModule

/**
 * Dagger [module][Module] for bookmark ui module.
 *
 * [BookmarkDomainModule] is included here because currently Hilt does not support pure java/kotlin
 * gradle modules.
 */
@Module(includes = [BookmarkDomainModule::class])
@InstallIn(ActivityRetainedComponent::class)
abstract class BookmarkUiModule
