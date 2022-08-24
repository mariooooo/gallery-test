package com.ddm.gallery_test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target
import com.ddm.gallery_test.databinding.GalleryItemBinding

class GalleryAdapter(private val context: Context,
                  private val photoList:List<Photo>
)
    : RecyclerView.Adapter<GalleryAdapter.GalleryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryItemViewHolder {
        val binding = GalleryItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return GalleryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryItemViewHolder, position: Int) {
        val photoItem = photoList[position]
        holder.bind(photoItem, position)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    inner class GalleryItemViewHolder(galleryItemBinding: GalleryItemBinding)
        : RecyclerView.ViewHolder(galleryItemBinding.root){

        private val binding = galleryItemBinding

        fun bind(photo: Photo, position:Int){
            binding.author.text = photo.user.name
            Glide.with(context)
                .load(photo.urls.small)
                .override(Target.SIZE_ORIGINAL)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(binding.photo)

            binding.photo.setOnClickListener {
                val intent = Intent(context, FullscreenActivity::class.java).apply {
                    putExtra("fullsize_url", photo.urls.full)
                    addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                }
                context.startActivity(intent)
            }
        }
    }
}