package com.chrynan.sample.di.module

import com.chrynan.sample.repository.ChordRepository
import com.chrynan.sample.repository.OpenGuitarChordSource
import dagger.Binds
import dagger.Module

@Module
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindChordRepository(source: OpenGuitarChordSource): ChordRepository
}