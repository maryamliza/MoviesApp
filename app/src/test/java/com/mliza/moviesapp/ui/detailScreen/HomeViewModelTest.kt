package com.mliza.moviesapp.ui.detailScreen

import com.mliza.moviesapp.data.MoviesRepository
import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.ui.homeScreen.HomeViewModel
import com.mliza.moviesapp.utils.BaseTest
import com.mliza.moviesapp.utils.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HomeViewModelTest : BaseTest() {

    private val moviesRepository = mockk<MoviesRepository>()
    lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(moviesRepository)
    }

    @Test
    fun `check if getMovies is fetched successfully`() {
//        GIVEN
        coEvery { moviesRepository.getMovies() } returns listOf(mockk(), mockk())

//        WHEN
        viewModel.getMovies()

//        THEN
        coVerify { moviesRepository.getMovies() }
        Assert.assertEquals(2, viewModel.listMoviesFiltered.getOrAwaitValue().size)
    }

    @Test
    fun `check if keyword is filtering results by name`() {
//        GIVEN
        coEvery { moviesRepository.getMovies() } returns listOf(
            Movie(name = "Avatar", actors = listOf("John")),
            Movie(name = "Parasite", actors = listOf("Yun")),
        )

//        WHEN
        viewModel.getMovies()
        viewModel.filter("Avat")

//        THEN
        Assert.assertEquals(1, viewModel.listMoviesFiltered.getOrAwaitValue().size)
    }

    @Test
    fun `check if keyword is filtering results by actors`() {
//        GIVEN
        coEvery { moviesRepository.getMovies() } returns listOf(
            Movie(name = "Avatar", actors = listOf("John")),
            Movie(name = "Parasite", actors = listOf("Yun", "John")),
        )

//        WHEN
        viewModel.getMovies()
        viewModel.filter("Joh")

//        THEN
        Assert.assertEquals(2, viewModel.listMoviesFiltered.getOrAwaitValue().size)
    }
}