package adeldolgov.emeter.common_di

import androidx.annotation.MainThread
import androidx.annotation.VisibleForTesting

abstract class ComponentHolder<Component : DIComponent> : BaseComponentHolder<Component> {

    private var component: Component? = null

    @MainThread
    override fun get(): Component {
        return component ?: build().also {
            component = it
        }
    }

    @VisibleForTesting
    override fun set(component: Component) {
        this.component = component
    }

    @MainThread
    protected abstract fun build(): Component

    @MainThread
    override fun clear() {
        component = null
    }
}
