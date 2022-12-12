package com.mliza.moviesapp.ui.detailScreen

import com.mliza.moviesapp.data.MoviesRepository
import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.utils.BaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailViewModelTest : BaseTest() {

    private val moviesRepository = mockk<MoviesRepository>()
    lateinit var viewModel: DetailViewModel

    @Before
    fun setup() {
        viewModel = DetailViewModel(moviesRepository)
    }

    @Test
    fun `check if getMovieDetail is fetched successfully`() {
//        GIVEN
        coEvery { moviesRepository.getMovieDetail("12") } returns Movie(name = "Avatar")

//        WHEN
        viewModel.getMovieDetail("12")

//        THEN
        coVerify { moviesRepository.getMovieDetail("12") }
        Assert.assertEquals("Avatar", viewModel.detailMovie.value?.name)
    }

    @Test
    fun `check if getMovieDetail is fetched with an error`() {
        coEvery { moviesRepository.getMovieDetail("3") } throws Exception()

        viewModel.getMovieDetail("3")

        coVerify { moviesRepository.getMovieDetail("3") }
        Assert.assertEquals(null, viewModel.detailMovie.value)
    }
}