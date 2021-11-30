package adeldolgov.emeter.login.presentation

import adeldolgov.emeter.common_ui.base.binding.BindingMvpActivity
import adeldolgov.emeter.common_ui.extensions.toast
import adeldolgov.emeter.databinding.ActivityLoginBinding
import adeldolgov.emeter.login.di.LoginPresentationComponentHolder
import adeldolgov.emeter.main.presentation.MainActivity
import android.os.Bundle
import android.view.LayoutInflater

/*
*@author Adel Dolgov on 21,Ноябрь,2021
*/
internal class LoginActivity : BindingMvpActivity<LoginPresenter, LoginView, ActivityLoginBinding>(), LoginView {

    override val bindingInflater: (LayoutInflater) -> ActivityLoginBinding
        get() = ActivityLoginBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        LoginPresentationComponentHolder.get().inject(this)
        super.onCreate(savedInstanceState)
        if (castedPresenter().isAuthorized()) {
            startActivity(MainActivity.createIntent(this))
            finishAffinity()
        } else {
            initUi()
        }
    }

    private fun initUi() {
        viewBinding.loginButton.setOnClickListener {
            castedPresenter().login(
                login = viewBinding.loginEditText.text.toString(),
                password = viewBinding.passwordEditText.text.toString()
            )
            viewBinding.loginButton.showLoading(true)
        }
    }

    override fun showSuccess() {
        viewBinding.loginButton.showLoading(false)
        startActivity(MainActivity.createIntent(this))
        finish()
    }

    override fun showError(error: Throwable) {
        viewBinding.loginButton.showLoading(false)
        toast(error.message.toString())
    }
}