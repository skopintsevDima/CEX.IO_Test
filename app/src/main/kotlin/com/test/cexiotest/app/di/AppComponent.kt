package com.test.cexiotest.app.di

import android.content.Context
import com.test.cexiotest.db.di.DbModule
import com.test.cexiotest.di.ActivityComponent
import com.test.cexiotest.movies.data.di.DataModule
import com.test.cexiotest.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    SubcomponentModule::class,
    DbModule::class,
    NetworkModule::class,
    DataModule::class
])
interface AppComponent {
    fun applicationContext(): Context

    fun activityComponent(): ActivityComponent.Factory
}