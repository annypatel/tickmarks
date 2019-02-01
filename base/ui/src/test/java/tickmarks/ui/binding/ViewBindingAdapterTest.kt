package tickmarks.ui.binding

import android.view.View
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ViewBindingAdapterTest {

    @Mock
    private lateinit var view: View

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun setVisibility_givenVisible__setVisibilityToVisible() {
        view.setVisibility(Visibility.VISIBLE)

        verify(view).visibility = View.VISIBLE
    }

    @Test
    fun setVisibility_givenInvisible_setVisibilityToInvisible() {
        view.setVisibility(Visibility.INVISIBLE)

        verify(view).visibility = View.INVISIBLE
    }

    @Test
    fun setVisibility_givenGone__setVisibilityToGone() {
        view.setVisibility(Visibility.GONE)

        verify(view).visibility = View.GONE
    }

    @Test
    fun setVisibility_givenNull__noChangeInVisibility() {
        view.setVisibility(null)

        verify(view, never()).visibility = any()
    }
}