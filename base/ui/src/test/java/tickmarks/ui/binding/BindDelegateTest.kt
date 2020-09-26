package tickmarks.ui.binding

import androidx.databinding.BaseObservable
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BindDelegateTest {

    @Test
    fun getValue_givenDelegateWithData_shouldReturnData() {
        val expectedValue = "Sample Data"
        val delegate = BindDelegate(12, expectedValue)

        val actualValue = delegate.getValue(mock(), mock())

        assertThat(actualValue, equalTo(expectedValue))
    }

    @Test
    fun setValue_givenDelegate_shouldSetData() {
        val expectedValue = "Updated Data"
        val delegate = BindDelegate(12, "Init Data")

        delegate.setValue(mock(), mock(), expectedValue)

        assertThat(delegate.getValue(mock(), mock()), equalTo(expectedValue))
    }

    @Test
    fun setValue_givenDelegate_shouldNotifyPropertyChanged() {
        val expectedFieldId = 12
        val observable = mock<BaseObservable>()
        val delegate = BindDelegate(expectedFieldId, "Init Data")

        delegate.setValue(observable, mock(), "Updated Data")

        verify(observable).notifyPropertyChanged(expectedFieldId)
    }
}
