package com.example.newsapp.repositories

import com.example.newsapp.api.JsonPlaceHolderService
import com.example.newsapp.api.dtos.User
import retrofit2.Retrofit

object UserRepository {
    suspend fun getUser(id: Int): User {
        val retrofit: Retrofit = Repository.getRetrofitInstance()
        val service = retrofit.create(JsonPlaceHolderService::class.java)
        return service.getUserById(id)
    }
}