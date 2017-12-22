package com.example.alexmets.kotlincleanarchexample.presentation.presenters

import android.view.View
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.Transformers
import rx.lang.kotlin.toSingletonObservable
import rx.Subscription
import java.util.*


class SomePresenter : Presenter{

    private val model = Transformers()

    private var view: View? =null
//    private var subscription = Subscription.empty()

    constructor(view: View)  {
        this.view = view
    }

    override fun onGetData() {
//        if (!subscription.isUnsubscribed()) {
//            subscription.unsubscribe();
//        }
        var subscription :Subscription=model.getProducts()



    }

}