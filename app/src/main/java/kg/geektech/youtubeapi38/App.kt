package kg.geektech.youtubeapi38

import android.app.Application
import kg.geektech.youtubeapi38.remote.ApiService
import kg.geektech.youtubeapi38.network.RetrofitClient
import kg.geektech.youtubeapi38.repositories.Repository

class App: Application() {

    val repository: Repository by lazy{
        Repository()
    }
    val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

}