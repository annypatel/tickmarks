package tickmarks.ui.binding

/**
 * An extension to [androidx.databinding.Observable] interface and provides [notifyPropertyChanged] and
 * [notifyChange] methods.
 */
interface Observable : androidx.databinding.Observable {

    /**
     * Notifies listeners that all properties of sender instance have changed.
     *
     * @param sender The sender of change notification.
     */
    fun notifyChange(sender: Observable)

    /**
     * Notifies listeners that a specific property has changed. The getter for the property that changes should be
     * marked with {@link Bindable} to generate a field in BR to be used as [fieldId].
     *
     * @param sender The sender of change notification.
     * @param fieldId The generated BR id for the Bindable field.
     */
    fun notifyPropertyChanged(sender: Observable, fieldId: Int)
}