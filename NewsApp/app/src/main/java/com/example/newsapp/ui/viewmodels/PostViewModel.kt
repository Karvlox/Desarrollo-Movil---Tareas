package com.example.newsapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.dtos.Comments
import com.example.newsapp.api.dtos.Post
import com.example.newsapp.api.dtos.User
import com.example.newsapp.repositories.CommentRepository
import com.example.newsapp.repositories.PostRepository
import com.example.newsapp.repositories.UserRepository
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val _post: MutableLiveData<Post> = MutableLiveData<Post>()
    private val _user: MutableLiveData<User> = MutableLiveData<User>()
    private val _comments: MutableLiveData<Comments> = MutableLiveData<Comments>(arrayListOf())

    val post: LiveData<Post> = _post
    val user: LiveData<User> = _user
    val comments: LiveData<Comments> = _comments

    fun getPost(id: Int) {
        viewModelScope.launch {
            val response = PostRepository.getPost(id)
            _post.postValue(response)
            response.userId?.let { userId ->
                getUser(userId)
            }
            response.id?.let { postId ->
                getComments(postId)
            }
        }
    }

    private fun getUser(userId: Int) {
        viewModelScope.launch {
            val response = UserRepository.getUser(userId)
            _user.postValue(response)
        }
    }

    private fun getComments(postId: Int) {
        viewModelScope.launch {
            val response = CommentRepository.getAll(postId)
            _comments.postValue(response)
        }
    }
}