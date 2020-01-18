package com.chrynan.sample.presenter

import com.chrynan.sample.coroutine.CoroutineDispatchers
import com.chrynan.sample.coroutine.PresenterCoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class Presenter(protected val dispatchers: CoroutineDispatchers) : PresenterCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = job + dispatchers.main

    var isBound = false
        private set

    private lateinit var job: Job

    fun bind() {
        job = SupervisorJob()
        isBound = true
    }

    fun unbind() {
        job.cancel()
        isBound = false
    }
}