package adeldolgov.emeter.common_ui.base.binding

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/*
*@author Adel Dolgov on 17,Апрель,2021
*/
abstract class BindingActivity<B : ViewBinding> : AppCompatActivity() {

    private var _binding: B? = null
    protected abstract val bindingInflater: (LayoutInflater) -> B

    protected val binding: B
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(_binding?.root ?: throw IllegalStateException("Binding cannot be null!"))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}