package com.test.cexiotest.di

import com.test.cexiotest.movies.domain.di.DomainModule
import com.test.cexiotest.movies.presentation.MoviesActivity
import com.test.cexiotest.network.NetworkModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ViewModelModule::class, DomainModule::class])
interface ActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(moviesActivity: MoviesActivity)
}