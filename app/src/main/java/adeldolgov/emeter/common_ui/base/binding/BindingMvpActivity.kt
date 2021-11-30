package adeldolgov.emeter.common_ui.base.binding

import adeldolgov.emeter.common_ui.base.BaseMvpActivity
import adeldolgov.emeter.common_ui.base.BasePresenter
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import moxy.MvpView

/*
*@author Adel Dolgov on 17,Апрель,2021
*/
abstract class BindingMvpActivity<P : BasePresenter<V>, V : MvpView, B : ViewBinding> : BaseMvpActivity<P, V>() {

    private var _viewBinding: B? = null
    protected abstract val bindingInflater: (LayoutInflater) -> B

    protected val viewBinding: B
        get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = bindingInflater.invoke(layoutInflater)
        setContentView(_viewBinding?.root ?: throw IllegalStateException("Binding cannot be null!"))
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}