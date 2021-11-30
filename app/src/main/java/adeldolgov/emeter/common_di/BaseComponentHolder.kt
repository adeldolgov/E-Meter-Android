package adeldolgov.emeter.common_di

interface BaseComponentHolder<Component: DIComponent> {

    fun get(): Component

    fun set(component: Component)

    fun clear()
}