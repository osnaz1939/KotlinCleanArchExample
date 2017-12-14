package com.example.alexmets.kotlincleanarchexample.content

import io.reactivex.Scheduler

interface Shedulers {

    abstract fun single(): Scheduler

    abstract fun io(): Scheduler

    abstract fun network(): Scheduler

    abstract fun computation(): Scheduler

    abstract fun mainThread(): Scheduler

}