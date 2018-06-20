package tickmarks.data.network

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module for exposing [NetworkClient] to application object graph.
 */
@Module(subcomponents = [NetworkComponent::class])
object NetworkModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideNetworkClient(builder: NetworkComponent.Builder): NetworkClient {
        return builder.build().networkClient()
    }
}