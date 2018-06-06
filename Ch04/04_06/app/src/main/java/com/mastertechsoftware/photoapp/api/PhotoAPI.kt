package com.mastertechsoftware.photoapp.api

import com.mastertechsoftware.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 *
 */
interface PhotoAPI {
    @GET("?key=9174671-f71a00ea24e6262aa0a6f8bf4&q=nature&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}