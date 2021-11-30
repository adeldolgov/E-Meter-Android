package adeldolgov.emeter.common_di

import androidx.annotation.MainThread
import androidx.annotation.VisibleForTesting
import java.lang.ref.WeakReference

abstract class FeatureComponentHolder<Component : DIComponent>: BaseComponentHolder<Component> {

    private var component: WeakReference<Component>? = null

    @MainThread
    override fun get(): Component {
        return component?.get() ?: build().also { component = WeakReference(it) }
    }

    @VisibleForTesting
    override fun set(component: Component) {
        this.component = WeakReference(component)
    }

    @MainThread
    protected abstract fun build(): Component

    @MainThread
    @VisibleForTesting
    override fun clear() {
        component = null
    }
}