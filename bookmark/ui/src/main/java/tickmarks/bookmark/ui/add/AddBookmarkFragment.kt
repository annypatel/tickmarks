package tickmarks.bookmark.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import tickmarks.bookmark.ui.add.AddBookmarkFragmentBinding.inflate
import tickmarks.ui.fragment.viewModel
import javax.inject.Inject

/**
 * Screen for adding bookmarks.
 */
class AddBookmarkFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var binding: AddBookmarkFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = viewModel<AddBookmarkViewModel>(factory)
        binding.viewModel = viewModel
    }
}