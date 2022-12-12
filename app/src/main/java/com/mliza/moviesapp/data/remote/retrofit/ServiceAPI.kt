package com.mliza.moviesapp.data.remote.retrofit

import com.mliza.moviesapp.data.models.Movie
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceAPI {
    @GET("movies")
    suspend fun getMovies(): List<Movie>

    @GET("movies/{id}")
    suspend fun getMovieDetail(@Path("id") id: String): Movie
}