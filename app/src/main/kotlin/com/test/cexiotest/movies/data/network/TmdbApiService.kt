package com.test.cexiotest.movies.data.network

import com.test.cexiotest.BuildConfig
import com.test.cexiotest.movies.domain.model.MoviesResults
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    companion object {
        const val MAIN_API_BASE_URL = "https://api.themoviedb.org/3/"
        const val MEDIA_TYPE_MOVIE = "movie"
        const val TIME_WINDOW_DAY = "day"
        private const val IMAGE_API_BASE_URL = "https://image.tmdb.org/t/p/"
        private const val POSTER_SIZE = "w500"

        fun buildPosterUrl(posterPath: String) = StringBuilder(IMAGE_API_BASE_URL)
            .append(POSTER_SIZE)
            .append(posterPath)
            .toString()
    }

    @GET("trending/{media_type}/{time_window}")
    fun trendingMovies(
        @Path("media_type") mediaType: String = MEDIA_TYPE_MOVIE,
        @Path("time_window") timeWindow: String = TIME_WINDOW_DAY,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
        ): Single<MoviesResults>
}