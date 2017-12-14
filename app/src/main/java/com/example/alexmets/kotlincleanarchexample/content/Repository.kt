package com.example.alexmets.kotlincleanarchexample.content

import android.support.annotation.CheckResult
import com.example.alexmets.kotlincleanarchexample.content.data.somefeature.SomeCleanModel
import com.example.alexmets.kotlincleanarchexample.content.impl.externall.data.somefeature.SomeRequestDTO
import io.reactivex.Single

interface Repository {
    @CheckResult
    fun getSomeData(requestDTO: SomeRequestDTO): Single<SomeCleanModel>
}