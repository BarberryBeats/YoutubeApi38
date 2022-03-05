package kg.geektech.youtubeapi38.ui.playlist_detail

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import kg.geektech.youtubeapi38.base.BaseActivity
import kg.geektech.youtubeapi38.databinding.ActivityPlaylistDetailBinding

class PlaylistDetailActivity : BaseActivity<PlaylistDetailViewModel, ActivityPlaylistDetailBinding>() {
    override val viewModel: PlaylistDetailViewModel by lazy {
        ViewModelProvider(this)[PlaylistDetailViewModel::class.java]
    }


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistDetailBinding {
       return ActivityPlaylistDetailBinding.inflate(inflater)
    }

}