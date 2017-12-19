package com.example.alexmets.kotlincleanarchexample.reactivex

import java.util.ArrayList

import io.reactivex.functions.Function

class AbstractTransformers {

    fun <A, B> list(transformer: Function<A, B>): (List<A>) -> ArrayList<B> {
        return { T: List<A> ->
            val B = ArrayList<B>(T.size)
            for (a in T) {
                B.add(transformer.apply(a))
            }
            B
        }
    }

    fun<T,R> getlist(transformer:(T)->R):(List<T>)->List<R>{
        return{A:List<T>->
            val B=ArrayList<R>(A.size)
            for(a in A){
                B.add(transformer(a))
            }
            B
        }
    }
}