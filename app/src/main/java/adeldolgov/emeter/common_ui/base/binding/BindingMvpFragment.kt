package adeldolgov.emeter.common_ui.base.binding

import adeldolgov.emeter.common_ui.base.BaseMvpFragment
import adeldolgov.emeter.common_ui.base.BasePresenter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import moxy.MvpView

/*
*@author Adel Dolgov on 17,Апрель,2021
*/
abstract class BindingMvpFragment<P : BasePresenter<V>, V : MvpView, B : ViewBinding> : BaseMvpFragment<P, V>() {

    private var _binding: B? = null
    protected abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> B

    protected val binding: B
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return _binding?.root ?: throw IllegalStateException("Binding cannot be null!")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}