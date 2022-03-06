package kg.geektech.youtubeapi38.ui.playlist

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.youtubeapi38.base.BaseActivity
import kg.geektech.youtubeapi38.databinding.ActivityPlaylistBinding
import kg.geektech.youtubeapi38.ext.makeToast
import kg.geektech.youtubeapi38.network.NetworkConnection
import kg.geektech.youtubeapi38.network.result.Status
import kg.geektech.youtubeapi38.ui.playlist_detail.PlaylistDetailActivity

class PlaylistActivity : BaseActivity<PlaylistsViewModel, ActivityPlaylistBinding>() {

    private lateinit var adapter: PlaylistAdapter
    override val viewModel: PlaylistsViewModel by lazy {
        ViewModelProvider(this)[PlaylistsViewModel::class.java]
    }

    override fun initView() {
        super.initView()
        adapter = PlaylistAdapter(this::onClick)
        binding.recyclerPlaylist.layoutManager = LinearLayoutManager(this)
        binding.recyclerPlaylist.adapter = adapter
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.getPlaylists().observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = INVISIBLE
                    binding.recyclerPlaylist.visibility = VISIBLE
                    it.data?.let { it1 ->
                        adapter.setPlaylist(it1.items)
                    }

                }
                Status.ERROR -> {
                    binding.progressBar.visibility = INVISIBLE
                    makeToast(it.message.toString())
                }

            }
        }

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.apply {
                    recyclerPlaylist.visibility = VISIBLE
                    noInternetLayout.visibility = INVISIBLE
                }
            } else {
                binding.apply {
                    noInternetLayout.visibility = VISIBLE
                    recyclerPlaylist.visibility = INVISIBLE
                }

            }
        }
    }

    private fun onClick(id: String, title: String, desc: String) {
        val intent = Intent(this, PlaylistDetailActivity::class.java)
        intent.putExtra("id", id)
        intent.putExtra("title", title)
        intent.putExtra("desc", desc)
        Log.d("Ray", id)
        startActivity(intent)
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(inflater)
    }


}