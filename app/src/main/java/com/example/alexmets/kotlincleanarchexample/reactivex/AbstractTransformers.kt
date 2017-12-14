package com.example.alexmets.kotlincleanarchexample.reactivex

import java.util.ArrayList

import io.reactivex.functions.Function

class AbstractTransformers {

    fun <A, B> list(transformer: Function<A, B>): (List<A>) -> ArrayList<B> {
        return { T: List<A> ->
            val B = ArrayList<B>(T.size)
            T.mapTo(B) { transformer.apply(it) }
            B
        }
    }
}