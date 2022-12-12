package com.mliza.moviesapp.ui.homeScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mliza.moviesapp.data.models.Movie
import com.mliza.moviesapp.databinding.ItemMovieBinding


class HomeAdapter(
    private val objList: List<Movie>,
    private val onItemClicked: (Movie) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = objList[position]
        val binding = holder.binding
        binding.tvMovieName.text = obj.name

        Glide.with(binding.ivImage.context)
            .load(obj.imageUrl)
            .into(binding.ivImage)

        binding.container.setOnClickListener {
            onItemClicked(obj)
        }
    }

    override fun getItemCount(): Int {
        return objList.size
    }
}