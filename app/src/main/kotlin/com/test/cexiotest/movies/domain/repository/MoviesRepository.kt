package com.test.cexiotest.movies.domain.repository

import com.test.cexiotest.movies.domain.model.Movie
import io.reactivex.Single

interface MoviesRepository {
    fun getMovies(): Single<List<Movie>>
}