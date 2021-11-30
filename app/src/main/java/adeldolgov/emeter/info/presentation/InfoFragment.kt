package adeldolgov.emeter.info.presentation

import adeldolgov.emeter.R
import adeldolgov.emeter.common_ui.base.binding.BindingFragment
import adeldolgov.emeter.databinding.FragmentInfoBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade

/*
*@author Adel Dolgov on 30,Ноябрь,2021
*/
internal class InfoFragment : BindingFragment<FragmentInfoBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInfoBinding
        get() = FragmentInfoBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        Glide.with(this)
            .load(R.drawable.profile_photo)
            .centerCrop()
            .transition(withCrossFade())
            .into(binding.profileImage)
    }

    companion object {

        fun newInstance(): InfoFragment {
            return InfoFragment()
        }
    }
}