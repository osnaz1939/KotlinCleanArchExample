package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeJacksonModel
import io.reactivex.functions.Function

class SomeDataTransformersFactory {
    internal fun jaccksonToCleanModel(): Function<SomeJacksonModel, SomeCleanModel> {
        return { i: SomeJacksonModel -> SomeCleanModel(i.mString,i.mInt) }
    }
}