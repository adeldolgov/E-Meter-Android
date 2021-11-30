package adeldolgov.emeter.counters.di.module

import adeldolgov.emeter.counters.domain.usecase.GetCountersUseCase
import adeldolgov.emeter.counters.domain.usecase.GetCountersUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface CountersModule {

    @Binds
    fun bindGetCountersUseCase(impl: GetCountersUseCaseImpl): GetCountersUseCase
}