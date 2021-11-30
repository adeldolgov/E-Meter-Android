package adeldolgov.emeter.app.di.module

import adeldolgov.emeter.app.domain.preferences.Preferences
import adeldolgov.emeter.app.domain.preferences.PreferencesImpl
import dagger.Binds
import dagger.Module

@Module
internal interface ApplicationModule {

    @Binds
    fun bindPreferences(impl: PreferencesImpl): Preferences
}