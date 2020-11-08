package tickmarks.base.data.injector

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.migration.DisableInstallInCheck
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrocrawler.jspoon.RetroCrawlerJSpoonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import tickmarks.base.data.network.NetworkClient
import java.util.concurrent.TimeUnit
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

/**
 * NetworkComponent exposes [NetworkClient] with [networkClient] provision method, dependencies
 * declared via [Subcomponent.modules] won't exposed outside this component.
 */
@Subcomponent(modules = [InternalNetworkModule::class])
interface NetworkComponent {

    @PrivateToComponent
    fun networkClient(): NetworkClient

    @Subcomponent.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}

/**
 * Dagger module for [NetworkComponent]. Defines dependencies required to constructs [NetworkClient]
 * . All the dependencies declared here is internal to [NetworkComponent] and won't be accessible
 * outside.
 *
 * InstallIn check is disabled as it is an internal module.
 */
@Module
@DisableInstallInCheck
object InternalNetworkModule {

    private const val BASE_URL = "http://api.example.com"
    private const val CONNECT_TIMEOUT = 10L
    private const val READ_TIMEOUT = 10L
    private const val WRITE_TIMEOUT = 10L

    @Provides
    @PrivateToComponent
    fun networkClient(retrofit: Retrofit): NetworkClient = NetworkClient(retrofit)

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(RetroCrawlerJSpoonConverterFactory.create())
            .build()
    }

    @Provides
    fun okHttpClient(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .apply {
                interceptors.forEach { addInterceptor(it) }
            }
            .build()
    }
}
