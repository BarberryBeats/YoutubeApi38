package kg.geektech.youtubeapi38.ui.playlist_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.youtubeapi38.databinding.ItemPlaylistDetailBinding
import kg.geektech.youtubeapi38.model.Items

class PlaylistDetailAdapter : RecyclerView.Adapter<PlaylistDetailAdapter.ViewHolder>() {

    private var playlistDetail = ArrayList<Items>();

    fun setPlaylist(playlist: ArrayList<Items>){
        playlistDetail = playlist
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPlaylistDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(playlistDetail[position])
    }

    override fun getItemCount(): Int = playlistDetail.size


    inner class ViewHolder(private val binding: ItemPlaylistDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(playlist: Items) {

        }
    }

}