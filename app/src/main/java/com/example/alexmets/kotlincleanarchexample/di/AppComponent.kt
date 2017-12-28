package com.example.alexmets.kotlincleanarchexample.di

import com.example.alexmets.kotlincleanarchexample.content.Repository
import com.example.alexmets.kotlincleanarchexample.content.impl.DefaultRepository
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.DefaultExternalDatasource
import com.example.alexmets.kotlincleanarchexample.presentation.presenters.SomePresenter
import com.example.alexmets.kotlincleanarchexample.presentation.ui.ItemFragment
import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(PresenterModule::class, ViewModule::class,AppModule::class, DataSourceModule::class))
interface AppComponent {
    abstract fun inject(dataRepository: DefaultRepository)
    abstract fun inject(externalData: DefaultExternalDatasource)
    abstract fun inject(presenter: SomePresenter)
    abstract fun inject(fragment: ItemFragment)
}