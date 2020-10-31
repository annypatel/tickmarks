package tickmarks.bookmark.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

/**
 * Screen for adding bookmarks.
 */
@AndroidEntryPoint
class AddBookmarkFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = AddBookmarkFragmentBinding.inflate(inflater, container, false)
            .apply {
                val vm by viewModels<AddBookmarkViewModel>()
                viewModel = vm
                viewState = viewModel?.viewState
            }
        return binding.root
    }
}
