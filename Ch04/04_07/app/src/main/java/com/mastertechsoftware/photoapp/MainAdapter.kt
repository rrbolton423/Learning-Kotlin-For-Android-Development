package com.mastertechsoftware.photoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mastertechsoftware.photoapp.models.Photo

// In the adapter's constructor, we want to pass in the main list of photos
// and a click listener. We also want our adapter to sub class RecyclerViewAdapter
class MainAdapter(var photos: List<Photo>,
                  var clickListener: View.OnClickListener) :
        RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {

    // This function binds the data to the Views in the RecyclerView
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {

        // Get the photo at the given position
        val photo = photos[position]

        // Set the tags field
        holder?.tags?.text = photo.tags

        // Set the likes field
        holder?.likes?.text = photo.likes.toString();

        // Set the favorites field
        holder?.favorites?.text = photo.favorites.toString();

        // If the previewURL is not empty...
        if (photo.previewURL.isNotEmpty()) {

            // Use Glide to load this image
            Glide.with(holder?.tags?.context)
                    .load(photo.previewURL)
                    .into(holder?.photo_item)
        }
    }

    // This function creates the Views in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {

        // Return an inflated photo_item row
        return PhotoViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.photo_item, parent, false))

    }

    // This function return the amount of photos we have
    override fun getItemCount(): Int {

        // Return the size of the photos list
        return photos.size
    }

    // This function is used to get a specific photo
    fun getPhoto(adapterPosition: Int): Photo {

        // Return the photo at the given position
        return photos[adapterPosition]
    }

    // PhotoViewHolder is a class that RecyclerView uses to store information about a
    // row on the screen. You will be given a View that ahas been inflated and will
    // pull out all of the fields it needs.
    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Declare the Views in the ViewHolder
        var tags: TextView
        var likes: TextView
        var favorites: TextView
        var photo_item: ImageView

        // Initialize...
        init {

            // Set a click listener on the MainView if one was provided
            if (clickListener != null) {

                // Set a click listener on the View
                itemView.setOnClickListener(clickListener)
            }

            // Set the tag of the main view to this ViewHolder. This
            // helps us find the holder later on
            itemView.tag = this

            // Find our fields
            tags = itemView.findViewById(R.id.tags)
            likes = itemView.findViewById(R.id.likes)
            favorites = itemView.findViewById(R.id.favorites)
            photo_item = itemView.findViewById(R.id.photo_item)
        }
    }

}