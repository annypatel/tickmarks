package tickmarks.base.data.injector

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import tickmarks.base.data.network.NetworkClient
import javax.inject.Singleton

/**
 * Dagger module for exposing [NetworkClient] to application object graph.
 */
@Module(subcomponents = [NetworkComponent::class])
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun networkClient(factory: NetworkComponent.Factory): NetworkClient =
        factory.create().networkClient()
}
