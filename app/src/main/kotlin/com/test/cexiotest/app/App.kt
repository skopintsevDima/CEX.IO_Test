package com.test.cexiotest.app

import android.app.Application
import com.test.cexiotest.app.di.AppComponent
import com.test.cexiotest.app.di.AppModule
import com.test.cexiotest.app.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        buildAppComponent()
    }

    private fun buildAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}