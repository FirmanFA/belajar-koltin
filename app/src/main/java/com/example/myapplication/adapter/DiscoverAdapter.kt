package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.data.model.MovieItem
import com.example.myapplication.databinding.RoomListLayoutBinding


class DiscoverAdapter(private val onClick:(MovieItem)->Unit)
    : ListAdapter<MovieItem, DiscoverAdapter.ViewHolder>(MovieItemComparator()) {


    class ViewHolder(private val binding: RoomListLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(currentMovieItem: MovieItem,
                 onClick: (MovieItem) -> Unit){

            binding.apply {
                this.tvNama.text = currentMovieItem.title
            }

        }

    }

    class MovieItemComparator : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RoomListLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

}