package com.test.cexiotest.app.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val context: Context
) {
    @Provides
    fun provideContext(): Context = context
}