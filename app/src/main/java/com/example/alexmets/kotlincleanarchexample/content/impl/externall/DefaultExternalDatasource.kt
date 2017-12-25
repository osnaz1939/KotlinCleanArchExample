package com.example.alexmets.kotlincleanarchexample.content.impl.externall

import com.example.alexmets.kotlincleanarchexample.R
import com.example.alexmets.kotlincleanarchexample.content.ExternalDataSource
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.Transformers
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import io.reactivex.Single
import io.reactivex.SingleSource

class DefaultExternalDatasource :ExternalDataSource{
    override fun getSomeData(requestDTO: SomeRequestDTO): Single<SomeCleanModel> {
        return Single.just<Any>(requestDTO)
                .map(ProductTransformersFactory.productsDTOtoPOOJO())
                .flatMap(Function<R, SingleSource<out R>> { mApiResource.productsApi().getProducts() })
                .map(Transformers.getProducts())
                .subscribeOn(mSchedulers.computation())
    }
}