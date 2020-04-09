package com.test.cexiotest.movies.data.di

import com.test.cexiotest.db.dao.MovieDao
import com.test.cexiotest.movies.data.network.TmdbApiService
import com.test.cexiotest.movies.data.repository.MoviesRepositoryImpl
import com.test.cexiotest.movies.domain.repository.MoviesRepository
import com.test.cexiotest.network.ConnectivityChecker
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    @Inject
    fun provideMoviesRepository(
        movieDao: MovieDao,
        apiService: TmdbApiService,
        connectivityChecker: ConnectivityChecker
    ): MoviesRepository = MoviesRepositoryImpl(movieDao, apiService, connectivityChecker)
}
