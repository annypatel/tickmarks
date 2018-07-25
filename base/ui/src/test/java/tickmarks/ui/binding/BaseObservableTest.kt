package tickmarks.ui.binding

import androidx.databinding.Observable.OnPropertyChangedCallback
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class BaseObservableTest {

    @Mock
    private lateinit var mockedCallback: OnPropertyChangedCallback
    private val observable = BaseObservable()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun notifyChange_givenObservableWithCallback_shouldInvokeCallback() {
        observable.addOnPropertyChangedCallback(mockedCallback)

        observable.notifyChange(observable)

        verify(mockedCallback).onPropertyChanged(observable, 0)
    }

    @Test
    fun notifyChange_givenObservableWithoutCallback_shouldNotInvokeCallback() {
        observable.addOnPropertyChangedCallback(mockedCallback)
        observable.removeOnPropertyChangedCallback(mockedCallback)

        observable.notifyChange(observable)

        verify(mockedCallback, never()).onPropertyChanged(observable, 0)
    }

    @Test
    fun notifyPropertyChanged_givenObservableWithCallback_shouldInvokeCallback() {
        val expectedFieldId = 42
        observable.addOnPropertyChangedCallback(mockedCallback)

        observable.notifyPropertyChanged(observable, expectedFieldId)

        verify(mockedCallback).onPropertyChanged(observable, expectedFieldId)
    }

    @Test
    fun notifyPropertyChanged_givenObservableWithoutCallback_shouldNotInvokeCallback() {
        val expectedFieldId = 42
        observable.addOnPropertyChangedCallback(mockedCallback)
        observable.removeOnPropertyChangedCallback(mockedCallback)

        observable.notifyPropertyChanged(observable, expectedFieldId)

        verify(mockedCallback, never()).onPropertyChanged(observable, expectedFieldId)
    }
}