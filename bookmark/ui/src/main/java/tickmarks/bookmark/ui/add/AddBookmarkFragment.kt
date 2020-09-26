package tickmarks.bookmark.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Screen for adding bookmarks.
 */
class AddBookmarkFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = AddBookmarkFragmentBinding.inflate(inflater, container, false)
            .apply {
                val vm by viewModels<AddBookmarkViewModel> { factory }
                viewModel = vm
                viewState = viewModel?.viewState
            }
        return binding.root
    }
}
