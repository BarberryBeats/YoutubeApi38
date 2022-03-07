package kg.geektech.youtubeapi38.remote

import kg.geektech.youtubeapi38.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //

    @GET("playlists")
    fun getPlayLists(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apikey: String,
        @Query("maxResults") maxResult: Int
    ): Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistItems(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") apikey: String,
        @Query("maxResults") maxResult: Int
    ): Call<Playlist>

}