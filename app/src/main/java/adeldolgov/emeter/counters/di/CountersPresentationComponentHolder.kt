package adeldolgov.emeter.counters.di

import adeldolgov.emeter.common_di.FeatureComponentHolder

internal object CountersPresentationComponentHolder : FeatureComponentHolder<CountersPresentationComponent>() {

    override fun build(): CountersPresentationComponent {
        return DaggerCountersPresentationComponent.factory().create()
    }
}