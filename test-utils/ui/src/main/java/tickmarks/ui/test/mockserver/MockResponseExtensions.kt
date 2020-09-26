package tickmarks.ui.test.mockserver

import android.content.Context
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import okhttp3.mockwebserver.MockResponse
import okio.Buffer

/**
 * Sets the response body from the given file in the assets folder.
 */
fun MockResponse.setBodyAsset(filePath: String): MockResponse {
    val ins = getApplicationContext<Context>().assets.open(filePath)
    setBody(Buffer().readFrom(ins))
    return this
}
