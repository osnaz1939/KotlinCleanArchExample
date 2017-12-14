package com.example.alexmets.kotlincleanarchexample.content.impl.externall.data

import com.fasterxml.jackson.annotation.JsonProperty

class Response<T>(@JsonProperty("header") private var mHeader: String, @JsonProperty("result") private var mResult: T) {

    val STATUS_OK = "OK"

    /* No args constructor. Required for Jackson */
    internal fun Response(){
        mHeader = null.toString()
    }

    fun Response(header: String,
                 result: T){
        mHeader = header
        mResult = result
    }

    fun header(): String {
        return mHeader
    }

    fun result(): T {
        return mResult
    }

    override fun toString(): String {
        return "ResultRo { header=" + mHeader +
                ", result=" + mResult + " }"
    }

}
