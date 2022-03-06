package kg.geektech.youtubeapi38.ui.playlist_detail

import androidx.lifecycle.LiveData
import kg.geektech.youtubeapi38.App
import kg.geektech.youtubeapi38.base.BaseViewModel
import kg.geektech.youtubeapi38.model.Playlist
import kg.geektech.youtubeapi38.network.result.Resource

class PlaylistDetailViewModel: BaseViewModel() {

    fun getPlaylistsItems(id: String?): LiveData<Resource<Playlist>> {
        return App().repository.getPlaylistsItems(id!!)
    }

}