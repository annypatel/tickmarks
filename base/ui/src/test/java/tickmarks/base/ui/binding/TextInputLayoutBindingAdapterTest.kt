package tickmarks.base.ui.binding

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import tickmarks.test.ui.equalToRes
import tickmarks.test.ui.themedContext

@RunWith(AndroidJUnit4::class)
class TextInputLayoutBindingAdapterTest {

    private val til = TextInputLayout(themedContext())

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
