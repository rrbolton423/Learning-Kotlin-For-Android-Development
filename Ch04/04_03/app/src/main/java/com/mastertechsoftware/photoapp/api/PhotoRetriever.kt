package com.mastertechsoftware.photoapp.api

import com.mastertechsoftware.photoapp.models.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRetriever {

    // Declare our Service
    private val service: PhotoAPI

    // Create an initialization method for creating the service
    // Since primary constructors cannot contain any code, Kotlin
    // uses the "init" code block for construction code.
    init {

        // Create the Retrofit object, specifying the baseUrl,
        // and converter factory, that will convert the results
        val retrofit = Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        // Initialize the Service object, passing the PhotoAPI class.
        // "class.java" is Kotlin's way of referencing a Java class object
        service = retrofit.create(PhotoAPI::class.java)
    }

    // Create a method to get those photos
    fun getPhotos(callback : Callback<PhotoList>) {

        // Call the getPhotos() method from the service object,
        // which will return a CallBack object when executed
        val call = service.getPhotos()

        // Execute the call asynchronously
        call.enqueue(callback)
    }
}