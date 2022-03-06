package kg.geektech.youtubeapi38.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.geektech.youtubeapi38.`object`.Constant
import kg.geektech.youtubeapi38.model.Playlist
import kg.geektech.youtubeapi38.network.RetrofitClient
import kg.geektech.youtubeapi38.network.result.Resource
import kg.geektech.youtubeapi38.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private  val apiService: ApiService by lazy {
        RetrofitClient.create()
    }
    fun getPlaylists(): LiveData<Resource<Playlist>> {

        val data = MutableLiveData<Resource<Playlist>>()
        data.value = Resource.loading()

        apiService.getPlayLists(
            Constant.part,
            Constant.channelId,
            "AIzaSyB7ZvDrd2AkOS-W9RCzVypc43j3t2F793k",
            Constant.maxResult
        ).enqueue(object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    data.value = Resource.error(t.message)
                }

            })
        return data
    }
    fun getPlaylistsItems(id: String): LiveData<Resource<Playlist>> {

        val data = MutableLiveData<Resource<Playlist>>()
        data.value = Resource.loading()

        apiService.getPlaylistItems(
            Constant.part,
            id,
            "AIzaSyB7ZvDrd2AkOS-W9RCzVypc43j3t2F793k",
            Constant.maxResult
        ).enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful) {
                    data.value = Resource.success(response.body())
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                data.value = Resource.error(t.message)
            }

        })
        return data
    }

}