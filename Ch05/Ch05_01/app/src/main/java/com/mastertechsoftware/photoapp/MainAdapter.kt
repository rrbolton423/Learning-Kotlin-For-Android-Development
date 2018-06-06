package com.mastertechsoftware.photoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mastertechsoftware.photoapp.models.Photo

/**
 *
 */
class MainAdapter(var photos:List<Photo>, var clickListener : View.OnClickListener?) : RecyclerView.Adapter<MainAdapter.PhotoHolder>() {
    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoHolder?, position: Int) {
        val photo = photos[position]
        holder?.title?.text = photo.tags
        holder?.user?.text = photo.user
        if (photo.userImageURL.isNotEmpty()) {
            Glide.with(holder?.title?.context)
                    .load(photo.userImageURL)
                    .into(holder?.avatar)
        }
        if (photo.previewURL.isNotEmpty()) {
            Glide.with(holder?.title?.context)
                    .load(photo.previewURL)
                    .into(holder?.photo_item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoHolder {
        return PhotoHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_item, parent, false))
    }

    fun getPhoto(adapterPosition: Int) : Photo {
        return photos[adapterPosition]
    }

    inner class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title : TextView
        var user : TextView
        var avatar : ImageView
        var photo_item : ImageView

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            title = itemView.findViewById(R.id.title) as TextView
            user = itemView.findViewById(R.id.user) as TextView
            avatar = itemView.findViewById(R.id.avatar) as ImageView
            photo_item = itemView.findViewById(R.id.photo_item) as ImageView
        }
    }

}