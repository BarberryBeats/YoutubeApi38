package kg.geektech.youtubeapi38.model

import com.google.gson.annotations.SerializedName

data class Playlist(
    val kind: String? = null,
    @SerializedName("etag")
    val tag: String? = null,
    val items: ArrayList<Items>,
    val snippet: Snippet
)

data class Items(
    val kind: String,
    val etag: String,
    val id: String,
    val snippet: Snippet,

    )

data class Snippet(

    val title: String? = null,
    val description: String? = null,
    val channelTitle: String? = null,
    val thumbnails: Thumbnails,
)

data class Thumbnails(
    val default: Default
)

data class Default(
    val url: String? = null
)



