package com.mastertechsoftware.photoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mastertechsoftware.photoapp.models.Photo

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Find our ImageView
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Get our Photo from the Intent, casting the return
        // type as a photo
        val photo = intent.getSerializableExtra(PHOTO) as Photo?

        // Load the photo into the ImageView
        photo?.webformatURL.let {
            Glide.with(this).load(photo?.webformatURL)
                    .into(imageView)
        }

        // When the ImageView is clicked...
        imageView.setOnClickListener {

            // Go back to MainActivity
            finish()
        }
    }

    // Companion objects is Kotlin's way of creating constants
    // and statics
    companion object {
        val PHOTO = "PHOTO"
    }
}
