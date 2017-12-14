package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SomeDataApi {

    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/api/rest/product/getProducts")
    abstract fun getSomeData(@Body body: SomeRequestDTO): Single<SomeCleanModel>
}