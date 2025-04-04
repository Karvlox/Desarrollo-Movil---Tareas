package com.example.newsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.api.dtos.Post
import com.example.newsapp.api.dtos.Posts
import com.example.newsapp.databinding.PostItemLayoutBinding

class PostAdapter(
    private var data: Posts,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostItemLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    fun setData(newData: Posts) {
        this.data = newData
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: PostItemLayoutBinding,
        private val onItemClick: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.postId.text = item.id.toString()
            binding.postTitle.text = item.title
            binding.root.setOnClickListener {
                onItemClick(item.id)
            }
        }
    }
}