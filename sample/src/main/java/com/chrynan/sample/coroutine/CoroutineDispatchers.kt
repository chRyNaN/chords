package com.chrynan.sample.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchers {

    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}