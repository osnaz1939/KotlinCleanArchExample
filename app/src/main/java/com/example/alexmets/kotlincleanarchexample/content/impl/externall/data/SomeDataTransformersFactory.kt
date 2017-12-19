package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeJacksonModel

class SomeDataTransformersFactory {

    fun jaccksonToCleanModel(t:SomeJacksonModel): (SomeJacksonModel) ->  SomeCleanModel{
        return {it->
            val r  =SomeCleanModel(t.mString,t.mInt)
            r
        }
    }

}

