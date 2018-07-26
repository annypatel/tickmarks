package tickmarks.ui.test.mockserver

import androidx.test.InstrumentationRegistry.getContext
import okhttp3.mockwebserver.MockResponse
import okio.Buffer

/**
 * Sets the response body from the given file in the assets folder.
 */
fun MockResponse.setBodyAsset(filePath: String): MockResponse {
    val ins = getContext().assets.open(filePath)
    body = Buffer().readFrom(ins)
    return this
}