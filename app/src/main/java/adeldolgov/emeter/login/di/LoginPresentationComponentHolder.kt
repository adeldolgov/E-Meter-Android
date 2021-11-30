package adeldolgov.emeter.login.di

import adeldolgov.emeter.common_di.FeatureComponentHolder
import adeldolgov.emeter.counters.di.CountersPresentationComponent
import adeldolgov.emeter.security.di.SecurityComponentHolder

internal object LoginPresentationComponentHolder : FeatureComponentHolder<LoginPresentationComponent>() {

    override fun build(): LoginPresentationComponent {
        return DaggerLoginPresentationComponent.factory().create(
            SecurityComponentHolder.get()
        )
    }
}