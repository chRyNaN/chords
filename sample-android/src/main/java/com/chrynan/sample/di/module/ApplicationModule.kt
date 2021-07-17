package com.chrynan.sample.di.module

import com.chrynan.sample.coroutine.AndroidCoroutineDispatchers
import com.chrynan.sample.coroutine.ApplicationCoroutineScope
import com.chrynan.sample.coroutine.CoroutineDispatchers
import com.chrynan.sample.ui.SampleApplication
import com.chrynan.sample.util.ApplicationContext
import dagger.Binds
import dagger.Module

@Module
internal abstract class ApplicationModule {

    @Binds
    abstract fun bindAppContext(application: SampleApplication): ApplicationContext

    @Binds
    abstract fun bindAppCoroutineScope(application: SampleApplication): ApplicationCoroutineScope

    @Binds
    abstract fun bindCoroutineDispatchers(dispatchers: AndroidCoroutineDispatchers): CoroutineDispatchers
}