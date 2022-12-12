package com.mliza.moviesapp.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: String = "",
    val name: String = "",
    @SerializedName("image_url") val imageUrl: String = "",
    val description: String = "",
    val actors: List<String> = listOf(),
    val directors: List<String> = listOf(),
    val origin: Location = Location(),
    val year: String = "",
    val duration: String = "",
    val rating: Double = 0.0,
    val genre: String = "",
) : Parcelable