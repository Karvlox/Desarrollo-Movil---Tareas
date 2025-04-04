package com.example.newsapp.repositories

import com.example.newsapp.api.JsonPlaceHolderService
import com.example.newsapp.api.dtos.Comments
import retrofit2.Retrofit

object CommentRepository {
    suspend fun getAll(postId: Int): Comments {
        val retrofit: Retrofit = Repository.getRetrofitInstance()
        val service = retrofit.create(JsonPlaceHolderService::class.java)
        return service.getCommentsByPostId(postId)
    }
}