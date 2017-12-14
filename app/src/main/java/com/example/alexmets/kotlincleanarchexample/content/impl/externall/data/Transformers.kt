package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import android.support.annotation.CheckResult
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeJacksonModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeResponseDTO
import com.example.alexmets.kotlincleanarchexample.reactivex.AbstractTransformers
import io.reactivex.functions.Function

class Transformers {
    @CheckResult
    fun getProducts(): Function<Response<SomeJacksonModel>, SomeCleanModel> {
        return { response: Response<SomeJacksonModel> ->
            val result = response.result()
            AbstractTransformers.list(SomeDataTransformersFactory.jaccksonToCleanModel()).apply(result)
        }
    }

    private fun Transformers(){
        // No instances
    }
}