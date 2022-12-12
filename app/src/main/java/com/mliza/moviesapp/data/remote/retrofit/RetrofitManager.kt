package com.mliza.moviesapp.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    private const val BASE_URL = "https://private-9d995-moviechallenge.apiary-mock.com/"

    fun getService(): ServiceAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ServiceAPI::class.java)
    }
}