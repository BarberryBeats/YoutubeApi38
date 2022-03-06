package kg.geektech.youtubeapi38.ui.playlist

import androidx.lifecycle.LiveData
import kg.geektech.youtubeapi38.App
import kg.geektech.youtubeapi38.base.BaseViewModel
import kg.geektech.youtubeapi38.model.Playlist
import kg.geektech.youtubeapi38.network.result.Resource

class PlaylistsViewModel : BaseViewModel() {

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        return App().repository.getPlaylists()
    }




}