package tickmarks.bookmark.ui.test

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import tickmarks.bookmark.ui.test.injector.DaggerTestBookmarkComponent

/**
 * Base application class for integration tests for Bookmark module.
 */
class TestBookmarkApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerTestBookmarkComponent.factory().create(this)
    }
}
