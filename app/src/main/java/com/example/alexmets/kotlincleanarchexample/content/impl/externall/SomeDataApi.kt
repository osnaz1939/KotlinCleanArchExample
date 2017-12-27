package com.example.alexmets.kotlincleanarchexample.content.impl.externall

import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.Response
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeJacksonModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SomeDataApi {

    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("/api/rest/product/getProducts")
     fun getSomeData(@Body body: SomeRequestDTO): Single<Response<SomeJacksonModel>>
}