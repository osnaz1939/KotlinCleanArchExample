package com.example.alexmets.kotlincleanarchexample.di

import android.app.Application
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


@Module
class AppModule {
    lateinit var mApplication: Application

    fun AppModule(mApplication: Application) {
        this.mApplication = mApplication
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }
}