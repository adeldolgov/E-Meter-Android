package adeldolgov.emeter.app.di

import adeldolgov.emeter.common_di.DataComponentHolder
import android.content.Context

object ApplicationComponentHolder : DataComponentHolder<ApplicationComponent, Context>() {

    override fun build(data: Context): ApplicationComponent {
        return DaggerApplicationComponent.factory().create(data)
    }
}