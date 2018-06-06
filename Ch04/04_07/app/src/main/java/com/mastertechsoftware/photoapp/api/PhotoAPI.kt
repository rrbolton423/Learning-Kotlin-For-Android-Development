package com.mastertechsoftware.photoapp.api

import com.mastertechsoftware.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

// Retrofit uses interfaces for creating the REST service
interface PhotoAPI {

    // The function getPhotos() returns a Call object
    // containing a list of PhotoList object
    // Add the @GET annotation to execute the API call, passing the
    // path to the service
    @GET("?key=9174671-f71a00ea24e6262aa0a6f8bf4&q=nature&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}