package tickmarks.base.data.injector

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.Multibinds
import okhttp3.Interceptor

/**
 * Dagger module for declaring no-op [HttpLoggingInterceptor] for release build.
 */
@Module
@InstallIn(ApplicationComponent::class)
abstract class LoggingInterceptorModule {

    @Multibinds
    abstract fun interceptors(): Set<Interceptor>
}
