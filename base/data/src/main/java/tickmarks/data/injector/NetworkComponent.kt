package tickmarks.data.injector

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import okhttp3.OkHttpClient
import retrocrawler.jspoon.RetroCrawlerJSpoonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import tickmarks.data.network.NetworkClient
import java.util.concurrent.TimeUnit

/**
 * NetworkComponent exposes [NetworkClient] with [networkClient] provision method, dependencies declared via
 * [Subcomponent.modules] won't exposed outside this component.
 */
@Subcomponent(modules = [InternalNetworkModule::class])
interface NetworkComponent {

    @PrivateToComponent
    fun networkClient(): NetworkClient

    @Subcomponent.Builder
    interface Builder {

        fun build(): NetworkComponent
    }
}

/**
 * Dagger module for [NetworkComponent]. Defines dependencies required to constructs [NetworkClient]. All the
 * dependencies declared here is internal to [NetworkComponent] and won't be accessible outside.
 */
@Module
object InternalNetworkModule {

    private const val BASE_URL = "http://api.example.com"
    private const val CONNECT_TIMEOUT = 10L
    private const val READ_TIMEOUT = 10L
    private const val WRITE_TIMEOUT = 10L

    @Provides
    @JvmStatic
    @PrivateToComponent
    fun networkClient(retrofit: Retrofit): NetworkClient {
        return NetworkClient(retrofit)
    }

    @Provides
    @JvmStatic
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(RetroCrawlerJSpoonConverterFactory.create())
            .build()
    }

    @Provides
    @JvmStatic
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}
