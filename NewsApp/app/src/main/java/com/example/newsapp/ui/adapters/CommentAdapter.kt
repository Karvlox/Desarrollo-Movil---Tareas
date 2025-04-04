package com.example.newsapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.api.dtos.Comment
import com.example.newsapp.api.dtos.Comments
import com.example.newsapp.databinding.CommentItemLayoutBinding

class CommentAdapter(
    private var data: Comments
) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CommentItemLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    fun setData(newData: Comments) {
        this.data = newData
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: CommentItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Comment) {
            Log.d("COMMENT", item.toString())
            binding.commentBody.text = item.body
            binding.commentEmail.text = item.email
            binding.commentName.text = item.name
        }
    }
}