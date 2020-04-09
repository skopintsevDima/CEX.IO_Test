package com.test.cexiotest.movies.domain.di

import com.test.cexiotest.di.ActivityScope
import com.test.cexiotest.movies.domain.repository.MoviesRepository
import com.test.cexiotest.movies.domain.usecase.GetMoviesUseCase
import com.test.cexiotest.movies.domain.usecase.GetMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class DomainModule {
    @ActivityScope
    @Provides
    @Inject
    fun provideGetMoviesUseCase(moviesRepository: MoviesRepository): GetMoviesUseCase
            = GetMoviesUseCaseImpl(moviesRepository)
}