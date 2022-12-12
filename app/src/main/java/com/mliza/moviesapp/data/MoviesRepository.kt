package com.mliza.moviesapp.data

import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.data.remote.RemoteDataSource

class MoviesRepository(
    private val remote: RemoteDataSource,
) {
    suspend fun getMovies(): List<Movie> {
        return try {remote.getMovies() } catch (e: Exception) { throw e}
    }

    suspend fun getMovieDetail(id: String): Movie {
        return remote.getMovieDetail(id)
    }
}
