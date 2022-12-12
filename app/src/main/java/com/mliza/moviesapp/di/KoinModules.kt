package com.mliza.moviesapp.di

import com.mliza.moviesapp.data.MoviesRepository
import com.mliza.moviesapp.data.remote.RemoteDataSource
import com.mliza.moviesapp.data.remote.retrofit.RetrofitManager
import com.mliza.moviesapp.ui.detailScreen.DetailViewModel
import com.mliza.moviesapp.ui.homeScreen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val repositoryModule = module {
    single { MoviesRepository(get()) }

    single { RemoteDataSource(get()) }
    single { RetrofitManager.getService() }
}

val viewModelsModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
