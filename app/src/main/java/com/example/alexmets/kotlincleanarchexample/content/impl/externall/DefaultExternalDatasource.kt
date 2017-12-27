package com.example.alexmets.kotlincleanarchexample.content.impl.externall

import com.example.alexmets.kotlincleanarchexample.content.ExternalDataSource
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.Transformers
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class DefaultExternalDatasource(private val mTransformers: Transformers, private val mApiResource: ApiResource) :ExternalDataSource{

    override fun getSomeData(requestDTO: SomeRequestDTO): Single<SomeCleanModel> {
        return Single.just(requestDTO)
                .flatMap{ mApiResource.someApi().getSomeData(it)  }
                .map { response -> mTransformers.getData(response) }
    }

}

