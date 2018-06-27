package tickmarks.bookmark.data.network

import pl.droidsonroids.jspoon.annotation.Selector

/**
 * Data class for html elements of a web page.
 */
data class WebPageElementsRaw(
    @Selector(value = "meta[property^=og:title]", attr = "content")
    var title: String? = null,

    @Selector(value = "meta[property^=og:url]", attr = "content")
    var url: String? = null,

    @Selector(value = "meta[property^=og:image]", attr = "content")
    var image: String? = null,

    @Selector(value = "meta[property^=og:description]", attr = "content")
    var description: String? = null
)