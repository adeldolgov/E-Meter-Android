package adeldolgov.emeter.security.di

import adeldolgov.emeter.app.di.ApplicationComponentHolder
import adeldolgov.emeter.common_di.FeatureComponentHolder

object SecurityComponentHolder : FeatureComponentHolder<SecurityComponent>() {

    override fun build(): SecurityComponent {
        return DaggerSecurityComponentInternal.factory().create(
            ApplicationComponentHolder.get()
        )
    }
}