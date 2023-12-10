package com.slayton.msu.nasaapi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.slayton.msu.nasaapi.api.GalleryItem
import com.slayton.msu.nasaapi.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(galleryItem: GalleryItem, onImageClicked: (
            photoUrl: String,
            photoTitle: String
    ) -> Unit) {
        binding.itemImageView.load(galleryItem.url)

        binding.root.setOnClickListener{
            onImageClicked(galleryItem.url, galleryItem.title)
        }
    }
}

class PhotoListAdapter(
    private val galleryItems: List<GalleryItem>,
    private val onImageClicked: (
        photoUrl: String,
        photoTitle: String
    ) -> Unit
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItems[position]
//        , onImageClicked
        holder.bind(item, onImageClicked)
    }
    override fun getItemCount() = galleryItems.size
}
