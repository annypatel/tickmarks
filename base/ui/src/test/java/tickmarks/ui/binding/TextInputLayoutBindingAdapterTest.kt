package tickmarks.ui.binding

import android.content.Context
import com.google.android.material.textfield.TextInputLayout
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TextInputLayoutBindingAdapterTest {

    @Mock
    private lateinit var til: TextInputLayout

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun setError_givenNone_setErrorToNull() {
        TextInputLayoutBindingAdapter.setError(til, NONE)

        verify(til).error = null
    }

    @Test
    fun setError_givenStringRes_setErrorToStringValue() {
        val stringRes = 123
        val expectedStringValue = "Hello, world!"
        val context = mock<Context>()
        whenever(context.getString(stringRes)).thenReturn(expectedStringValue)
        whenever(til.context).thenReturn(context)

        TextInputLayoutBindingAdapter.setError(til, stringRes)

        verify(til).error = expectedStringValue
    }
}