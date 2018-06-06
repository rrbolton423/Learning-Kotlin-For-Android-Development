package com.mastertechsoftware.photoapp.api

import com.mastertechsoftware.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 *
 */
interface PhotoAPI {
    @GET("?key=<key>&q=nature&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}