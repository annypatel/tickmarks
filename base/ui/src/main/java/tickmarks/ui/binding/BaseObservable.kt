package tickmarks.ui.binding

import androidx.databinding.Observable.OnPropertyChangedCallback
import androidx.databinding.PropertyChangeRegistry

/**
 * A convenience base class that implements [Observable].
 */
open class BaseObservable : Observable {

    @delegate:Transient
    private val registry by lazy { PropertyChangeRegistry() }

    override fun notifyChange(sender: Observable) {
        registry.notifyCallbacks(sender, 0, null)
    }

    override fun notifyPropertyChanged(sender: Observable, fieldId: Int) {
        registry.notifyCallbacks(sender, fieldId, null)
    }

    override fun removeOnPropertyChangedCallback(callback: OnPropertyChangedCallback) {
        registry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: OnPropertyChangedCallback) {
        registry.add(callback)
    }
}