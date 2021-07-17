package com.chrynan.sample.ui

import com.chrynan.sample.coroutine.ApplicationCoroutineScope
import com.chrynan.sample.di.component.ApplicationComponent
import com.chrynan.sample.di.component.DaggerApplicationComponent
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class SampleApplication : DaggerApplication(),
        ApplicationCoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()

    override fun applicationInjector(): ApplicationComponent =
            DaggerApplicationComponent.builder().application(this).build()
}