package com.mastertechsoftware.photoapp.models

import java.io.Serializable

/**
 * Kotlin has a unique take on classes that act as a model or a POJO,
 * Plain Old Java Object.Most model classes will have fields with some
 * setters and getters, plus an equals and hashCode method.
 * If you find yourself writing these boiler-plate methods all the time,
 * data classes will save you time. Kotlin automatically creates getters,
 * setters, equals, and hashCode methods for you. You'll just refer to the field,
 * and Kotlin will use the getter/setter for that field. We will be creating data
 * classes to match the JSON data we get back from calling our REST API.
 */
// This Kotlin data class holds the photo information
data class Photo(val id : String,
                 val likes : Int,
                 val favorites : Int,
                 val tags : String,
                 val previewURL : String,
                 val webformatURL : String) : Serializable {
}