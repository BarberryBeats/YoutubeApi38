package kg.geektech.youtubeapi38.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.youtubeapi38.databinding.ItemPlaylistBinding
import kg.geektech.youtubeapi38.ext.loadImage
import kg.geektech.youtubeapi38.model.Items
import kg.geektech.youtubeapi38.model.Playlist

class PlaylistAdapter(private val onClick: (id: String, title: String, desc: String) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {


    private var playlist = ArrayList<Items>()

    fun setPlaylist(playlist: ArrayList<Items>) {
        this.playlist = playlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistAdapter.ViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int = playlist.size


    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.apply {
                tvTitle.text = playlist.snippet.title
                tvDescription.text = playlist.snippet.description
                Log.d("Ray", playlist.id)
                playlist.snippet.thumbnails.default.url?.let { ivPlaylist.loadImage(it) }
                tvPlaylistName.text = playlist.snippet.channelTitle

                itemView.setOnClickListener {
                    playlist.snippet.title?.let { it1 ->
                        playlist.snippet.description?.let { it2 ->
                            onClick(
                                playlist.id,
                                it1, it2
                            )
                        }
                    }
                }
            }
        }
    }

}