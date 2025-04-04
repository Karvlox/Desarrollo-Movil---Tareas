package com.example.newsapp.api.dtos

typealias Posts = ArrayList<Post>

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)