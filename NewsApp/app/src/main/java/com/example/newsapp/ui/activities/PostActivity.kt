package com.example.newsapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityPostBinding
import com.example.newsapp.ui.adapters.CommentAdapter
import com.example.newsapp.ui.viewmodels.PostViewModel
import kotlin.properties.Delegates

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    private val viewModel: PostViewModel by viewModels()
    private var postId by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        postId = intent.getIntExtra("POST_ID", -1)

        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
        setupObservers()

        if (postId != -1) {
            viewModel.getPost(postId)
        }
    }

    private fun setupObservers() {
        viewModel.post.observe(this) { post ->
            binding.postTitle.text = post.title
            binding.postBody.text = post.body
        }

        viewModel.user.observe(this) { user ->
            binding.postAuthor.text = user.name
        }

        viewModel.comments.observe(this) { comments ->
            binding.commentsTitle.text = "Comments (${comments.size})"
            val adapter = binding.comments.adapter as CommentAdapter
            adapter.setData(comments)
        }
    }

    private fun setupRecyclerView() {
        val adapter = CommentAdapter(arrayListOf())
        binding.comments.apply {
            layoutManager = LinearLayoutManager(this@PostActivity)
            addItemDecoration(DividerItemDecoration(this@PostActivity, LinearLayoutManager.VERTICAL))
            this.adapter = adapter
        }
    }
}
