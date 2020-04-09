package com.test.cexiotest.db.dao

import androidx.room.*
import com.test.cexiotest.movies.domain.model.Movie
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAll(): Single<List<Movie>>

    @Insert
    fun insertAll(movies: List<Movie>)

    @Query("DELETE FROM movie")
    fun removeAll(): Completable
}