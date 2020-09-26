package tickmarks.ui.viewmodel

import io.reactivex.Flowable
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class BaseViewModelTest {

    class TestViewModel : BaseViewModel() {

        fun subscribeAndAutoDispose() {
            Flowable.just(1, 2, 3)
                .subscribe()
                .autoDispose()
        }

        // overridden with public modifier to make it accessible in tests
        public override fun onCleared() {
            super.onCleared()
        }
    }

    @Test
    fun autoDispose_givenSubscription_shouldAddDisposable() {
        val viewModel = TestViewModel()
        viewModel.subscribeAndAutoDispose()

        assertThat(viewModel.disposables.size(), equalTo(1))
    }

    @Test
    fun onCleared_givenSubscription_shouldClearDisposables() {
        val viewModel = TestViewModel()
        viewModel.subscribeAndAutoDispose()

        viewModel.onCleared()

        assertThat(viewModel.disposables.size(), equalTo(0))
    }
}
