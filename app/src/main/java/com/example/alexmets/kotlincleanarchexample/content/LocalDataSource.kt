package com.example.alexmets.kotlincleanarchexample.content

import android.support.annotation.CheckResult
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeResponseDTO
import io.reactivex.Single

interface LocalDataSource {
    @CheckResult
    fun saveSomeData(resultDTO: SomeResponseDTO): Single<SomeCleanModel>

}