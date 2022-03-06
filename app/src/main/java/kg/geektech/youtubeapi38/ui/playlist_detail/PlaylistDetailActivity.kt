package kg.geektech.youtubeapi38.ui.playlist_detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kg.geektech.youtubeapi38.base.BaseActivity
import kg.geektech.youtubeapi38.databinding.ActivityPlaylistDetailBinding
import kg.geektech.youtubeapi38.ext.makeToast
import kg.geektech.youtubeapi38.network.NetworkConnection
import kg.geektech.youtubeapi38.network.result.Status

class PlaylistDetailActivity :
    BaseActivity<PlaylistDetailViewModel, ActivityPlaylistDetailBinding>() {
    private lateinit var adapter: PlaylistDetailAdapter
    override val viewModel: PlaylistDetailViewModel by lazy {
        ViewModelProvider(this)[PlaylistDetailViewModel::class.java]
    }


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistDetailBinding {
        return ActivityPlaylistDetailBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()
        adapter = PlaylistDetailAdapter()
        binding.recyclerPlaylistDetail.layoutManager = LinearLayoutManager(this)
        binding.recyclerPlaylistDetail.adapter = adapter

    }

    override fun initListener() {
        super.initListener()
        binding.containerBack.setOnClickListener {
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun initViewModel() {
        super.initViewModel()
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.apply {

                    noInternetLayout.visibility = INVISIBLE
                }
            } else {
                binding.apply {

                    noInternetLayout.visibility = VISIBLE
                }

            }
        }
        viewModel.getPlaylistsItems(intent.getStringExtra("id")).observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = INVISIBLE
                    it.data.let { it1 ->
                        it1?.let { it2 -> adapter.setPlaylist(it2.items) }
                    }

                }
                Status.ERROR -> {
                    binding.progressBar.visibility = INVISIBLE
                    makeToast(it.message.toString())
                }

            }
        }

    }
}

