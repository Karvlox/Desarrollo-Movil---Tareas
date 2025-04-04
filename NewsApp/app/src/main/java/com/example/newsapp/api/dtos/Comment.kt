package com.example.newsapp.api.dtos

typealias Comments = ArrayList<Comment>

data class Comment (
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
