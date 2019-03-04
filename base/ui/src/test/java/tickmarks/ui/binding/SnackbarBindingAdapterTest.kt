package tickmarks.ui.binding

import android.view.ContextThemeWrapper
import android.view.View
import android.widget.FrameLayout
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import tickmarks.ui.R
import tickmarks.ui.event.Event
import tickmarks.ui.event.consume
import tickmarks.ui.test.hasNoSnackbar
import tickmarks.ui.test.hasSnackbar
import tickmarks.ui.test.withMessage

@RunWith(AndroidJUnit4::class)
class SnackbarBindingAdapterTest {

    private lateinit var container: View

    @Before
    fun setUp() {
        val context = ContextThemeWrapper(getApplicationContext(), R.style.Theme_AppCompat)
        container = FrameLayout(context)
    }

    @Test
    fun showSnackbar_givenEvent_shouldShowSnackbar() {
        val snackbarMsg = android.R.string.ok

        container.showSnackbar(Event(snackbarMsg))

        assertThat(container, hasSnackbar(withMessage(snackbarMsg)))
    }

    @Test
    fun showSnackbar_givenConsumedEvent_shouldNotShowSnackbar() {
        val snackbarMsg = android.R.string.ok
        val event = Event(snackbarMsg)
        event.consume { }

        container.showSnackbar(event)

        assertThat(container, hasNoSnackbar())
    }

    @Test
    fun showSnackbar_givenNull_shouldNotShowSnackbar() {
        container.showSnackbar(null)

        assertThat(container, hasNoSnackbar())
    }
}