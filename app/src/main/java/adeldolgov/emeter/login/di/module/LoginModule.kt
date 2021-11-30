package adeldolgov.emeter.login.di.module

import adeldolgov.emeter.login.domain.usecase.AuthorizationUseCase
import adeldolgov.emeter.login.domain.usecase.AuthorizationUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface LoginModule {

    @Binds
    fun bindAuthrozationUseCase(impl: AuthorizationUseCaseImpl): AuthorizationUseCase
}