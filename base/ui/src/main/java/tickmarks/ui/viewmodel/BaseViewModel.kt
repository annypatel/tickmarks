package tickmarks.ui.viewmodel

import tickmarks.ui.binding.BaseObservable
import tickmarks.ui.binding.Observable

/**
 * View model with support for observing data-bindings and [auto-dispose][autoDispose] for reactive observables.
 */
abstract class BaseViewModel :
    RxViewModel(),
    Observable by BaseObservable()