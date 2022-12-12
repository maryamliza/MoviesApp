package com.mliza.moviesapp.data.remote

import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.data.remote.retrofit.ServiceAPI
import retrofit2.http.GET
import retrofit2.http.Path

class RemoteDataSource(
    private val service: ServiceAPI
) {
    suspend fun getMovies(): List<Movie> {
        return service.getMovies()
    }
    suspend fun getMovieDetail(id: String): Movie {
        return service.getMovieDetail(id)
    }
}
