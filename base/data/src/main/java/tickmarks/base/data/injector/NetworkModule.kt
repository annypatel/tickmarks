package tickmarks.base.data.injector

import dagger.Module
import dagger.Provides
import tickmarks.base.data.network.NetworkClient
import javax.inject.Singleton

/**
 * Dagger module for exposing [NetworkClient] to application object graph.
 */
@Module(subcomponents = [NetworkComponent::class])
object NetworkModule {

    @Provides
    @Singleton
    fun networkClient(factory: NetworkComponent.Factory): NetworkClient =
        factory.create().networkClient()
}
