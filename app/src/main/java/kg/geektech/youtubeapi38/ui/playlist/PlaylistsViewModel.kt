package kg.geektech.youtubeapi38.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.geektech.youtubeapi38.BuildConfig.API_KEY
import kg.geektech.youtubeapi38.`object`.Constant
import kg.geektech.youtubeapi38.base.BaseViewModel
import kg.geektech.youtubeapi38.model.Playlist
import kg.geektech.youtubeapi38.remote.ApiService
import kg.geektech.youtubeapi38.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistsViewModel : BaseViewModel() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlists(): LiveData<Playlist> {
        return getPlaylists()
    }

    private fun getPlaylists(): LiveData<Playlist> {

        val data = MutableLiveData<Playlist>()

        apiService.getPlayLists(Constant.part, Constant.channelId, API_KEY, Constant.maxResult)
            .enqueue(object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {

                }

            })
        return data
    }

}