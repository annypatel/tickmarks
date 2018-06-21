package tickmarks.ui.rx

import io.reactivex.Flowable
import io.reactivex.rxkotlin.plusAssign
import org.junit.Assert.assertThat
import org.junit.Test
import org.hamcrest.CoreMatchers.`is` as Is

class RxViewModelTest {

    class TestViewModel : RxViewModel() {

        fun subscribe() {
            disposables += Flowable.just(1, 2, 3)
                .subscribe()
        }

        // overridden with public modifier to make it accessible in tests
        public override fun onCleared() {
            super.onCleared()
        }
    }

    @Test
    fun onCleared_givenViewModelWithSubscription_shouldClearDisposables() {
        val viewModel = TestViewModel()
        viewModel.subscribe()

        viewModel.onCleared()

        assertThat(viewModel.disposables.size(), Is(0))
    }
}