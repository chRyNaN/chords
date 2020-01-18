package com.chrynan.sample.coroutine

import kotlinx.coroutines.Dispatchers

class AndroidCoroutineDispatchers : CoroutineDispatchers {

    override val main = Dispatchers.Main
    override val default = Dispatchers.Default
    override val io = Dispatchers.IO
    override val unconfined = Dispatchers.Unconfined
}