package com.example.alexmets.kotlincleanarchexample.presentation.presenters

import android.view.View
import com.example.alexmets.kotlincleanarchexample.content.Repository
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.Transformers
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import com.example.alexmets.kotlincleanarchexample.reactivex.AbstractTransformers
import io.reactivex.android.schedulers.AndroidSchedulers

import rx.Subscription
import rx.schedulers.Schedulers


class SomePresenter : Presenter{

    private var mRepository:Repository

    override fun onSavedState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRestoreState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val model = Transformers()

    private var view: View
//    private var subscription = Subscription.empty()

    constructor(view: View, mRepository: Repository)  {
        this.view = view
        this.mRepository = mRepository
    }

    override fun onGetData() {
//        if (!subscription.isUnsubscribed()) {
//            subscription.unsubscribe();
//        }
//        var subscription :Subscription=
        val someRequest=SomeRequestDTO("mTest")
           mRepository.getSomeData(someRequest)
                   .subscribeOn(io.reactivex.schedulers.Schedulers.computation())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(this::onDataLoaded);
    }

    fun onDataLoaded(model:SomeCleanModel){

    }

}