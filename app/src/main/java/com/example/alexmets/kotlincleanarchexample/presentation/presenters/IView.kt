package com.example.alexmets.kotlincleanarchexample.presentation.presenters

import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel

interface IView {
    fun showList(someList:List<SomeCleanModel>)
}