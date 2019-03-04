package tickmarks.ui.binding

import android.view.ContextThemeWrapper
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import tickmarks.ui.R
import tickmarks.ui.test.equalToRes

@RunWith(AndroidJUnit4::class)
class TextInputLayoutBindingAdapterTest {

    private lateinit var til: TextInputLayout

    @Before
    fun setup() {
        val context = ContextThemeWrapper(getApplicationContext(), R.style.Theme_AppCompat)
        til = TextInputLayout(context)
    }

    @Test
    fun setError_givenNone_setErrorToNull() {
        til.setError(NONE)

        assertThat(til.error, nullValue())
    }

    @Test
    fun setError_givenStringRes_setErrorToStringValue() {
        val stringRes = android.R.string.ok

        til.setError(stringRes)

        assertThat(til.error, equalToRes(stringRes))
    }
}