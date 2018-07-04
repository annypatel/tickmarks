package tickmarks.ui.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * Returns an existing ViewModel or creates a new one in the fragment scope, associated with this `ViewModelProvider`.
 *
 * @see ViewModelProvider.get(Class)
 */
inline fun <reified VM : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory) =
    ViewModelProviders.of(this, factory).get(VM::class.java)