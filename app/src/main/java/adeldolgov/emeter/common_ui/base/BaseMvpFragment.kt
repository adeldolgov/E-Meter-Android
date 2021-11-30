package adeldolgov.emeter.common_ui.base

import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

open class BaseMvpFragment<P : BasePresenter<V>, V : MvpView> : MvpAppCompatFragment() {

    @Inject
    protected lateinit var presenterProvider: Provider<P>

    private val presenter: BasePresenter<V> by moxyPresenter { providePresenter() }

    private fun providePresenter(): BasePresenter<V> {
        return presenterProvider.get()
    }

    fun castedPresenter() : P {
        return presenter as P
    }
}