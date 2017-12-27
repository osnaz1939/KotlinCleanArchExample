package com.example.alexmets.kotlincleanarchexample.di

import com.example.alexmets.kotlincleanarchexample.content.ExternalDataSource
import dagger.Provides
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

class ModelModule {
    @Provides
    @Singleton
    internal fun provideDataSource(): ExternalDataSource {
        return  ExternalDataSource.getSomeData()
    }

}