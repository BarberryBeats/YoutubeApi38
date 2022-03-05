package kg.geektech.youtubeapi38.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.youtubeapi38.databinding.ItemPlaylistBinding
import kg.geektech.youtubeapi38.ext.loadImage
import kg.geektech.youtubeapi38.model.Items

class PlaylistAdapter(private val onClick: (id: String) -> Unit) : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {


    private var playlist = ArrayList<Items>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistAdapter.ViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlist[position])
    }

    override fun getItemCount(): Int = playlist.size

    fun setPlaylist(playlist: ArrayList<Items>) {
        this.playlist = playlist
    }


    inner class ViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {
            binding.apply {
                tvTitle.text = playlist.snippet.title
                tvDescription.text = playlist.snippet.description
                playlist.snippet.thumbnails.default.url?.let { ivPlaylist.loadImage(it) }
                tvPlaylistName.text = playlist.snippet.channelTitle

                itemView.setOnClickListener {
                    onClick(playlist.id)
                }
            }
        }
    }

}