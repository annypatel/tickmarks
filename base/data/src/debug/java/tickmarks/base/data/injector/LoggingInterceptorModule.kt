package tickmarks.base.data.injector

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Dagger module for declaring [HttpLoggingInterceptor] for debug build.
 */
@Module
@InstallIn(ApplicationComponent::class)
object LoggingInterceptorModule {

    @IntoSet
    @Provides
    fun loggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }
}
