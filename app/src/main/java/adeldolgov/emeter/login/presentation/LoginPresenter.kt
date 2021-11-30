package adeldolgov.emeter.login.presentation

import adeldolgov.emeter.common_ui.base.rx.RxPresenter
import adeldolgov.emeter.login.domain.usecase.AuthorizationUseCase
import adeldolgov.emeter.security.domain.SecurityManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/*
*@author Adel Dolgov on 21,Ноябрь,2021
*/
internal class LoginPresenter @Inject constructor(
    private val securityManager: SecurityManager,
    private val authorizationUseCase: AuthorizationUseCase,
) : RxPresenter<LoginView>() {

    fun isAuthorized(): Boolean {
        return securityManager.isAuthorized
    }

    fun login(login: String, password: String) {
        authorizationUseCase(login, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { securityManager.token = it.token; viewState.showSuccess() },
                onError = { viewState.showError(it) }
            )
            .disposeOnFinish()
    }
}