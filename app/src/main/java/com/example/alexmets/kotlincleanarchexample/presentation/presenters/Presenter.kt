package com.example.alexmets.kotlincleanarchexample.presentation.presenters

interface Presenter {
     fun onGetData()
     fun onSavedState()
     fun onRestoreState()
}