package com.mliza.moviesapp.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mliza.moviesapp.data.MoviesRepository
import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.utils.combineWith
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _error: MutableLiveData<String> = MutableLiveData()
    private val listMovies: MutableLiveData<List<Movie>> = MutableLiveData()
    private val keyword: MutableLiveData<String> = MutableLiveData()

    val error: LiveData<String> = _error
    val listMoviesFiltered = listMovies.combineWith(keyword) { list, key ->
        if (key == null) return@combineWith list.orEmpty()
        list?.filter {
            val isInName = it.name.contains(key, ignoreCase = true)
            val isInActors =
                it.actors.joinToString(separator = "|").contains(key, ignoreCase = true)
            val isInDirectors =
                it.directors.joinToString(separator = "|").contains(key, ignoreCase = true)
            isInName || isInActors || isInDirectors
        }.orEmpty()
    }

    fun filter(keyword: String) {
        this.keyword.value = keyword
    }

    fun getMovies() = viewModelScope.launch {
        try {
            listMovies.value = repository.getMovies()
        } catch (e: Exception) {
            e.printStackTrace()
            _error.value = e.localizedMessage
        }
    }
}