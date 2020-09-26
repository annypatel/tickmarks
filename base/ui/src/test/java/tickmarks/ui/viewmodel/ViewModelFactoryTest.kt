package tickmarks.ui.viewmodel

import androidx.lifecycle.ViewModel
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import javax.inject.Provider

class ViewModelFactoryTest {

    @Test
    fun create_givenViewModelMap_returnsViewModel() {
        val factory = ViewModelFactory(
            mapOf(
                TestViewModel::class.java to Provider<ViewModel> { TestViewModel() }
            )
        )

        val viewModel = factory.create(TestViewModel::class.java)

        assertThat(viewModel, instanceOf(TestViewModel::class.java))
    }

    @Test
    fun create_givenViewModelMap_returnsAssignableViewModel() {
        val factory = ViewModelFactory(
            mapOf(
                ChildTestViewModel::class.java to Provider<ViewModel> { ChildTestViewModel() }
            )
        )

        val viewModel = factory.create(TestViewModel::class.java)

        assertThat(viewModel, instanceOf(ChildTestViewModel::class.java))
    }

    @Test(expected = IllegalStateException::class)
    fun create_givenEmptyMap_throwsException() {
        val factory = ViewModelFactory(mapOf())
        factory.create(TestViewModel::class.java)
    }

    private open class TestViewModel : ViewModel()
    private class ChildTestViewModel : TestViewModel()
}
