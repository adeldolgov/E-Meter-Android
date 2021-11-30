package adeldolgov.emeter.common_di

import androidx.annotation.MainThread
import androidx.annotation.VisibleForTesting

abstract class DataComponentHolder<Component : DIComponent, Data: Any>: BaseComponentHolder<Component> {

    private var component: Component? = null

    @MainThread
    override fun get(): Component {
        return requireNotNull(component) { "Component not found" }
    }

    @MainThread
    fun init(data: Data) {
        component ?: build(data).also { component = it }
    }

    @VisibleForTesting
    override fun set(component: Component) {
        this.component = component
    }

    @MainThread
    protected abstract fun build(data: Data): Component

    @MainThread
    @VisibleForTesting
    override fun clear() {
        component = null
    }
}