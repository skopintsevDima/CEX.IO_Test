package com.test.cexiotest.network

import android.content.Context
import android.net.ConnectivityManager
import com.test.cexiotest.movies.data.network.TmdbApiService
import com.test.cexiotest.movies.data.network.TmdbApiService.Companion.MAIN_API_BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideTmdbApiService(): TmdbApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(MAIN_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(TmdbApiService::class.java)
    }

    @Singleton
    @Provides
    @Inject
    fun provideConnectivityChecker(context: Context): ConnectivityChecker {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return ConnectivityCheckerImpl(cm)
    }
}