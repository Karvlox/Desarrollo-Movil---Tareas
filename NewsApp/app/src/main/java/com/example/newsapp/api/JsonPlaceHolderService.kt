package com.example.newsapp.api

import com.example.newsapp.api.dtos.Comments
import com.example.newsapp.api.dtos.Post
import com.example.newsapp.api.dtos.Posts
import com.example.newsapp.api.dtos.User
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderService {
    @GET("posts")
    suspend fun getPosts(): Posts

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    @GET("posts/{id}/comments")
    suspend fun getCommentsByPostId(@Path("id") id: Int): Comments

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): User
}
