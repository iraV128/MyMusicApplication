package com.example.myassssmentapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView Adapter for displaying a list of Album items.
 *
 * @param onItemClick A lambda function triggered when an album item is clicked.
 */
class AlbumAdapter(
    private val onItemClick: (Album) -> Unit
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    // Internal list to store Album objects
    private var albums = listOf<Album>()

    /**
     * Updates the album list and notifies the adapter to refresh the UI.
     */
    fun setAlbums(list: List<Album>) {
        albums = list
        notifyDataSetChanged()
    }

    /**
     * ViewHolder class that holds references to item views and binds data.
     */
    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvArtist: TextView = itemView.findViewById(R.id.tvArtist) // Artist name view
        val tvAlbum: TextView = itemView.findViewById(R.id.tvAlbum)   // Album title view
        val tvGenre: TextView = itemView.findViewById(R.id.tvGenre)   // Genre view

        /**
         * Binds a given Album to the UI components.
         */
        fun bind(album: Album) {
            tvArtist.text = album.artistName
            tvAlbum.text = album.albumTitle
            tvGenre.text = album.genre

            // Handle item click
            itemView.setOnClickListener {
                onItemClick(album)
            }
        }
    }

    /**
     * Creates a new ViewHolder by inflating the album item layout.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return AlbumViewHolder(view)
    }

    /**
     * Binds each album item to the ViewHolder.
     */
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(albums[position])
    }

    /**
     * Returns the total number of album items.
     */
    override fun getItemCount(): Int = albums.size
}
