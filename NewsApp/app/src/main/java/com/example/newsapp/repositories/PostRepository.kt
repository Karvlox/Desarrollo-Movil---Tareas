package com.example.newsapp.repositories

import com.example.newsapp.api.JsonPlaceHolderService
import com.example.newsapp.api.dtos.Post
import com.example.newsapp.api.dtos.Posts
import retrofit2.Retrofit

object PostRepository {

    private val retrofit: Retrofit = Repository.getRetrofitInstance()
    private val service = retrofit.create(JsonPlaceHolderService::class.java)

    suspend fun getAll(): Posts {
        return service.getPosts()
    }

    suspend fun getPost(id: Int): Post {
        return service.getPostById(id)
    }
}