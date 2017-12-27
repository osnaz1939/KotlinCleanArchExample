package com.example.alexmets.kotlincleanarchexample.di

import com.example.alexmets.kotlincleanarchexample.content.Repository
import com.example.alexmets.kotlincleanarchexample.content.impl.DefaultRepository
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.DefaultExternalDatasource
import com.example.alexmets.kotlincleanarchexample.presentation.presenters.SomePresenter
import com.example.alexmets.kotlincleanarchexample.presentation.ui.ItemFragment
import javax.inject.Singleton

import dagger.Component

@Singleton
@Component(modules = arrayOf(ModelModule::class, PresenterModule::class, ViewModule::class))
interface AppComponent {
    abstract fun inject(dataRepository: DefaultRepository)
    abstract fun inject(externalData: DefaultExternalDatasource)
    abstract fun inject(presenter: SomePresenter)
    abstract fun inject(fragment: ItemFragment)
}