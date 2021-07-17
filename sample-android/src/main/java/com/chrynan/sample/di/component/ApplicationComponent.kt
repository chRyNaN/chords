package com.chrynan.sample.di.component

import com.chrynan.sample.di.module.ActivityBuilderModule
import com.chrynan.sample.di.module.ApplicationModule
import com.chrynan.sample.di.module.RepositoryModule
import com.chrynan.sample.ui.SampleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ApplicationModule::class,
            ActivityBuilderModule::class,
            RepositoryModule::class
        ]
)
interface ApplicationComponent : AndroidInjector<SampleApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: SampleApplication): Builder

        fun build(): ApplicationComponent
    }
}