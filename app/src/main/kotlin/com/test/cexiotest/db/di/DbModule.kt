package com.test.cexiotest.db.di

import android.content.Context
import androidx.room.Room
import com.test.cexiotest.db.AppDatabase
import com.test.cexiotest.db.AppDatabase.Companion.APP_DATABASE_NAME
import com.test.cexiotest.db.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    @Inject
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao = appDatabase.movieDao()

    @Provides
    @Singleton
    @Inject
    fun provideAppDatabase(applicationContext: Context): AppDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, APP_DATABASE_NAME
    ).build()
}