package com.example.alexmets.kotlincleanarchexample.content.impl

import com.example.alexmets.kotlincleanarchexample.content.ExternalDataSource
import com.example.alexmets.kotlincleanarchexample.content.Repository
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import io.reactivex.Single

class DefaultRepository(private val mExternalDatasource:ExternalDataSource) : Repository{

    override fun getSomeData(requestDTO: SomeRequestDTO): Single<SomeCleanModel> {
       return  mExternalDatasource.getSomeData(requestDTO)
    }
}