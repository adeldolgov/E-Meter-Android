package adeldolgov.emeter.app.di

import adeldolgov.emeter.app.di.module.ApplicationModule
import adeldolgov.emeter.app.domain.preferences.Preferences
import adeldolgov.emeter.common_di.DIComponent
import android.content.Context
import dagger.BindsInstance
import dagger.Component

/*
*@author Adel Dolgov on 21,Ноябрь,2021
*/
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : DIComponent {

    fun context(): Context

    fun preferences(): Preferences

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}