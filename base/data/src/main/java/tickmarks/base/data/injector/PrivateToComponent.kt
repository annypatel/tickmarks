package tickmarks.base.data.injector

import dagger.Subcomponent
import javax.inject.Qualifier

/**
 * Qualifier annotation for dependency that is private to component. Generally used in
 * [Subcomponent] to encapsulate the implementation details within the sub-component and modules.
 * Refer [Subcomponents for encapsulation](https://google.github.io/dagger/subcomponents).
 */
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class PrivateToComponent
