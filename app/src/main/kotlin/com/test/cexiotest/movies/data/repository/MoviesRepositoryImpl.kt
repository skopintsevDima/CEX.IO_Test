package com.test.cexiotest.movies.data.repository

import android.util.Log
import com.test.cexiotest.db.dao.MovieDao
import com.test.cexiotest.movies.data.network.TmdbApiService
import com.test.cexiotest.movies.domain.model.Movie
import com.test.cexiotest.movies.domain.repository.MoviesRepository
import com.test.cexiotest.network.ConnectivityChecker
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val apiService: TmdbApiService,
    private val connectivityChecker: ConnectivityChecker
): MoviesRepository {
    override fun getMovies(): Single<List<Movie>> =
        if (!connectivityChecker.isNetworkConnected()) movieDao.getAll()
        else refreshMovies().andThen(movieDao.getAll())

    private fun refreshMovies(): Completable = loadMovies()
        .flatMapCompletable { movies -> saveMovies(movies) }

    private fun loadMovies() = apiService.trendingMovies()
        .doOnSuccess { Log.d(TAG, "Loading movies completed.") }
        .map { it.results }
        .onErrorResumeNext {
            Log.d(TAG, it.message?:"Movies loading failed: unknown issue.")
            Single.error(Throwable("Movies loading failed."))
        }

    private fun saveMovies(movies: List<Movie>) = movieDao.removeAll()
        .doOnComplete { Log.d(TAG, "Removing old movies completed.") }
        .onErrorResumeNext {
            Log.d(TAG, it.message?:"Old movies removing failed: unknown issue.")
            Completable.error(Throwable("Old movies removing failed."))
        }
        .andThen(Completable.fromAction { movieDao.insertAll(movies) })
        .doOnComplete { Log.d(TAG, "Saving movies completed.") }
        .onErrorResumeNext {
            Log.d(TAG, it.message?:"Movies saving failed: unknown issue.")
            Completable.error(Throwable("Movies saving failed."))
        }

    companion object {
        const val TAG = "MoviesRepositoryImpl"
    }
}