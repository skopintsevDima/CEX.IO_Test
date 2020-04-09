package com.test.cexiotest.movies.domain.usecase

import com.test.cexiotest.movies.domain.model.Movie
import com.test.cexiotest.movies.domain.repository.MoviesRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMoviesUseCaseImpl @Inject constructor(
   val moviesRepository: MoviesRepository
): GetMoviesUseCase {
    override fun invoke(): Single<List<Movie>> = moviesRepository.getMovies()
}