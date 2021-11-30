package adeldolgov.emeter.common_ui.base

import moxy.MvpPresenter
import moxy.MvpView
import javax.inject.Inject

open class BasePresenter<V: MvpView> @Inject constructor() : MvpPresenter<V>()