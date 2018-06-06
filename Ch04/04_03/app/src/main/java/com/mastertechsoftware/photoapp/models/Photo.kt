package com.mastertechsoftware.photoapp.models

import java.io.Serializable

/**
 *
 */
data class Photo(val id: String, val user_id: String,
                 val user: String, val tags: String,
                 val userImageURL : String,
                 val previewURL : String,
                 val webformatURL : String) : Serializable {
}