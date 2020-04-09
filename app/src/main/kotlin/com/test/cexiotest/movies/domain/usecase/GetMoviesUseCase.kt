package com.test.cexiotest.movies.domain.usecase

import com.test.cexiotest.movies.domain.model.Movie
import io.reactivex.Single

interface GetMoviesUseCase {
    fun invoke(): Single<List<Movie>>
}