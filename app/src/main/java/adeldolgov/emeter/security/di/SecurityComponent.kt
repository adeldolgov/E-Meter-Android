package adeldolgov.emeter.security.di

import adeldolgov.emeter.app.di.ApplicationComponent
import adeldolgov.emeter.common_di.DIComponent
import adeldolgov.emeter.security.di.module.SecurityModule
import adeldolgov.emeter.security.domain.SecurityManager
import dagger.Component

interface SecurityComponent : DIComponent {

    fun securityManager(): SecurityManager
}

@Component(
    dependencies = [
        ApplicationComponent::class
    ],
    modules = [
        SecurityModule::class
    ]
)
internal interface SecurityComponentInternal : SecurityComponent {

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent
        ): SecurityComponentInternal
    }
}