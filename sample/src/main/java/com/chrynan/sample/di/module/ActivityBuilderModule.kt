package com.chrynan.sample.di.module

import com.chrynan.sample.di.module.activity.MainActivityModule
import com.chrynan.sample.di.scope.ActivityScope
import com.chrynan.sample.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity
}