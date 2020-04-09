package com.test.cexiotest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.cexiotest.db.AppDatabase.Companion.APP_DATABASE_VERSION
import com.test.cexiotest.movies.domain.model.Movie
import com.test.cexiotest.db.dao.MovieDao

@Database(entities = [Movie::class], version = APP_DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        const val APP_DATABASE_VERSION = 1
        const val APP_DATABASE_NAME = "Test.db"
    }
}