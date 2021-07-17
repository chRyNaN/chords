package com.chrynan.sample.coroutine

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class AndroidCoroutineDispatchers @Inject constructor() : CoroutineDispatchers {

    override val main = Dispatchers.Main
    override val default = Dispatchers.Default
    override val io = Dispatchers.IO
    override val unconfined = Dispatchers.Unconfined
}