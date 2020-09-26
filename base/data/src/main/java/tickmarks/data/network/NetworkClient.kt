package tickmarks.data.network

import retrofit2.Retrofit
import kotlin.reflect.KClass

/**
 * Client for creating an implementation of the API endpoints defined by the Retrofit service interface.
 */
class NetworkClient(
    private val retrofit: Retrofit
) {

    /**
     * Create an implementation of the API endpoints.
     */
    fun <T : Any> create(serviceClass: KClass<T>): T {
        return retrofit.create(serviceClass.java)
    }
}
