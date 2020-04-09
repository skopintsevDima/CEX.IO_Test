package com.test.cexiotest.movies.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.cexiotest.R
import com.test.cexiotest.movies.domain.model.Movie

class MoviesAdapter(private var movies: List<Movie>): RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val movieItemView = layoutInflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieItemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun setItems(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}
