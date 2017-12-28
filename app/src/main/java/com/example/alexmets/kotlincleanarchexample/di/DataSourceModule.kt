package com.example.alexmets.kotlincleanarchexample.di

import android.app.Application
import com.example.alexmets.kotlincleanarchexample.content.ExternalDataSource
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.ApiResource
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.DefaultExternalDatasource
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.Transformers
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataSourceModule {

    lateinit var mBaseUrl: String

    fun NetModule(mBaseUrl: String) {
        this.mBaseUrl = mBaseUrl
    }


    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.getCacheDir(), cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    @FirstScope
    internal fun provideDataSource(mTransformers: Transformers, mApiResource: ApiResource): ExternalDataSource {
        return  DefaultExternalDatasource( mTransformers, mApiResource)
    }

    annotation class FirstScope
}