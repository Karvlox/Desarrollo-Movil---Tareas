package com.example.newsapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.dtos.Post
import com.example.newsapp.api.dtos.Posts
import com.example.newsapp.repositories.PostRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _posts: MutableLiveData<Posts> = MutableLiveData<Posts>(arrayListOf<Post>())
    val posts: LiveData<Posts> = _posts

    fun getPosts() {
        viewModelScope.launch {
            val response = PostRepository.getAll()
            _posts.postValue(response)
        }
    }
}