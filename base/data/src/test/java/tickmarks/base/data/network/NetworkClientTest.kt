package tickmarks.base.data.network

import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNotNull
import org.junit.Test
import retrofit2.Retrofit

class NetworkClientTest {

    interface ApiService

    @Test
    fun create_givenServiceClass_returnsInstanceOfService() {
        val client = NetworkClient(
            Retrofit.Builder()
                .baseUrl("http://api.example.com")
                .build()
        )

        val apiService = client.create(ApiService::class)

        assertNotNull(apiService)
        assertThat(apiService, instanceOf(ApiService::class.java))
    }
}
