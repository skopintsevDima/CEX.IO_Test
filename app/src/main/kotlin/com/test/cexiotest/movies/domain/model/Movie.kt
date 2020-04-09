package com.test.cexiotest.movies.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @SerializedName("vote_average") @ColumnInfo(name = "vote_average") val averageVote: Double,
    @SerializedName("poster_path") @ColumnInfo(name = "poster_path") val posterPath: String
)