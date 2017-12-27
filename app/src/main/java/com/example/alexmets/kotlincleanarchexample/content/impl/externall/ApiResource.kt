package com.example.alexmets.kotlincleanarchexample.content.impl.externall

import android.support.annotation.CheckResult

interface ApiResource {
    @CheckResult
    fun someApi(): SomeDataApi
}