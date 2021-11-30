package adeldolgov.emeter.login.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

internal interface LoginView : MvpView {

    @AddToEndSingle
    fun showSuccess()

    @AddToEndSingle
    fun showError(error: Throwable)
}