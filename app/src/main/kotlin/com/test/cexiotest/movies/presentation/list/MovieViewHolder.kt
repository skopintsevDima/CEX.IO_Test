package com.test.cexiotest.movies.presentation.list

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.test.cexiotest.R
import com.test.cexiotest.movies.data.network.TmdbApiService.Companion.buildPosterUrl
import com.test.cexiotest.movies.domain.model.Movie
import kotlin.random.Random

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val moviePoster: AppCompatImageView = itemView.findViewById(R.id.moviePoster)
    private val movieTitle: AppCompatTextView = itemView.findViewById(R.id.movieTitle)
    private val movieOverview: AppCompatTextView = itemView.findViewById(R.id.movieOverview)
    private val movieVote: AppCompatTextView = itemView.findViewById(R.id.movieVote)

    fun bind(movie: Movie){
        val resources = moviePoster.context.resources
        val posterWidthPx = resources.getDimensionPixelSize(R.dimen.posterWidth)
        val posterHeightPx = resources.getDimensionPixelSize(R.dimen.posterHeight)
        Picasso.get()
            .load(buildPosterUrl(movie.posterPath))
            .placeholder(R.drawable.ic_image_grey_24dp)
            .error(R.drawable.ic_broken_image_grey_24dp)
            .resize(posterWidthPx, posterHeightPx)
            .centerCrop()
            .into(moviePoster)
        movieTitle.text = movie.title
        movieOverview.text = movie.overview
        movieVote.text = itemView.context.getString(R.string.vote, movie.averageVote.toString())
        val colorId = when (Random.nextInt(0, 4)){
            0 -> R.color.movieItemBackground1
            1 -> R.color.movieItemBackground2
            2 -> R.color.movieItemBackground3
            3 -> R.color.movieItemBackground4
            else -> R.color.movieItemBackground1
        }
        itemView.setBackgroundResource(colorId)
    }
}