package tickmarks.bookmark.ui.test

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Base application class for integration tests for Bookmark module.
 */
class TestBookmarkApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerTestBookmarkComponent.builder()
            .create(this)
    }
}