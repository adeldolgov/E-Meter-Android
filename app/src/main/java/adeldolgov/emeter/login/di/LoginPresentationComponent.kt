package adeldolgov.emeter.login.di

import adeldolgov.emeter.common_di.DIComponent
import adeldolgov.emeter.login.di.module.LoginModule
import adeldolgov.emeter.login.presentation.LoginActivity
import adeldolgov.emeter.security.di.SecurityComponent
import dagger.Component

@Component(
    dependencies = [
        SecurityComponent::class,
    ],
    modules = [LoginModule::class]
)
internal interface LoginPresentationComponent : DIComponent {

    fun inject(loginActivity: LoginActivity)

    @Component.Factory
    interface Factory {

        fun create(
            securityComponent: SecurityComponent,
        ): LoginPresentationComponent
    }
}