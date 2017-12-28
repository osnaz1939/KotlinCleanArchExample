package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeJacksonModel
import com.example.alexmets.kotlincleanarchexample.di.DataSourceModule
import javax.inject.Inject

@DataSourceModule.FirstScope
class Transformers {

    @Inject
    constructor()

    fun getData(response:Response<SomeJacksonModel>):SomeCleanModel {
            val result = response.result()
            val cleanResult:SomeCleanModel=jaccksonToCleanModel(result)
            return cleanResult
    }

    private fun jaccksonToCleanModel(t:SomeJacksonModel): SomeCleanModel {
            val r  =SomeCleanModel(t.mString,t.mInt)
            return r
    }

    private fun Transformers(){
        // No instances
    }
}