package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import android.support.annotation.CheckResult
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeJacksonModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeResponseDTO
import com.example.alexmets.kotlincleanarchexample.reactivex.AbstractTransformers
import io.reactivex.functions.Function

class Transformers {

    fun getProducts(): (Response<SomeJacksonModel>) -> SomeCleanModel {
        return { response: Response<SomeJacksonModel> ->
            val result = response.result()
            val cleanResult:SomeCleanModel=jaccksonToCleanModel(result)
            cleanResult
        }
    }

    private fun jaccksonToCleanModel(t:SomeJacksonModel): SomeCleanModel {
            val r  =SomeCleanModel(t.mString,t.mInt)
            return r
    }


    private fun Transformers(){
        // No instances
    }
}