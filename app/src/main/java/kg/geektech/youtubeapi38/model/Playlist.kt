package kg.geektech.youtubeapi38.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class Playlist(
    val kind: String? = null,
    @SerializedName("etag")
    val tag: String? = null,
    val items: ArrayList<Items>,
    val snippet: Snippet,
    val pageInfo: PageInfo
)

data class Items(
    val kind: String,
    val etag: String,
    val id: String,
    val snippet: Snippet,
    val contentDetails: ContentDetails,

    )

data class Snippet(

    val title: String? = null,
    val description: String? = null,
    val channelTitle: String? = null,
    val publishedAt: Date? = null,
    val thumbnails: Thumbnails,
)

data class Thumbnails(
    val default: Default
)

data class Default(
    val url: String? = null
)

data class PageInfo(
    val totalResults: Int? = null
)

data class ContentDetails(
    val itemCount: Int? = null
)



