package tickmarks.ui.binding

import android.view.View
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
        ViewBindingAdapter.setVisibility(view, Visibility.VISIBLE)

        verify(view).visibility = View.VISIBLE
    }

    @Test
    fun setVisibility_givenInvisible_setVisibilityToInvisible() {
        ViewBindingAdapter.setVisibility(view, Visibility.INVISIBLE)

        verify(view).visibility = View.INVISIBLE
    }

    @Test
    fun setVisibility_givenGone__setVisibilityToGone() {
        ViewBindingAdapter.setVisibility(view, Visibility.GONE)

        verify(view).visibility = View.GONE
    }
}