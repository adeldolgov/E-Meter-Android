package adeldolgov.emeter.counters.di

import adeldolgov.emeter.common_di.DIComponent
import adeldolgov.emeter.counters.di.module.CountersModule
import adeldolgov.emeter.counters.presentation.CountersFragment
import dagger.Component

@Component(
    modules = [CountersModule::class]
)
internal interface CountersPresentationComponent : DIComponent {

    fun inject(countersFragment: CountersFragment)

    @Component.Factory
    interface Factory {

        fun create(): CountersPresentationComponent
    }
}