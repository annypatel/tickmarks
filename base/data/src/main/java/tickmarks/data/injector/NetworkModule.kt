package tickmarks.data.injector

import dagger.Module
import dagger.Provides
import tickmarks.data.network.NetworkClient
import javax.inject.Singleton

/**
 * Dagger module for exposing [NetworkClient] to application object graph.
 */
@Module(subcomponents = [NetworkComponent::class])
object NetworkModule {

    @Provides
    @Singleton
    @JvmStatic
    fun networkClient(builder: NetworkComponent.Builder): NetworkClient =
        builder.build().networkClient()
}
