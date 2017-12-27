package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import android.support.annotation.CheckResult
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeJacksonModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeResponseDTO
import com.example.alexmets.kotlincleanarchexample.reactivex.AbstractTransformers
import io.reactivex.functions.Function
import rx.Observable
import rx.Single

class Transformers {

    fun getData(response:Response<SomeJacksonModel>):SomeCleanModel {
            val result = response.result()
            val cleanResult:SomeCleanModel=jaccksonToCleanModel(result)
            return cleanResult
    }

    private fun jaccksonToCleanModel(t:SomeJacksonModel): SomeCleanModel {
            val r  =SomeCleanModel(t.mString,t.mInt)
            return r
    }

//    fun getRepoList(name: String): Observable<List<RepositoryDTO>> {
//        return apiInterface
//                .getRepositories(name)
//                .compose(applySchedulers<T>())
//    }


    private fun Transformers(){
        // No instances
    }
}