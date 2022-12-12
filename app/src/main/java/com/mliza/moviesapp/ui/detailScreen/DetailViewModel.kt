package com.mliza.moviesapp.ui.detailScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mliza.moviesapp.data.MoviesRepository
import com.mliza.moviesapp.data.models.Movie
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: MoviesRepository,
) : ViewModel() {
    val detailMovie: MutableLiveData<Movie> = MutableLiveData()

    fun getMovieDetail(id: String) {
        viewModelScope.launch {
            detailMovie.value = repository.getMovieDetail(id)
        }
    }
}