package com.example.newsapp.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}