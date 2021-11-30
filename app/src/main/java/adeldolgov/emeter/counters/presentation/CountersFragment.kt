package adeldolgov.emeter.counters.presentation

import adeldolgov.emeter.common_ui.base.binding.BindingMvpFragment
import adeldolgov.emeter.common_ui.base.recyclerview.BaseItem
import adeldolgov.emeter.common_ui.extensions.isShimmering
import adeldolgov.emeter.common_ui.extensions.toast
import adeldolgov.emeter.counters.di.CountersPresentationComponentHolder
import adeldolgov.emeter.counters.presentation.adapter.CountersAdapter
import adeldolgov.emeter.counters.presentation.adapter.HeaderCounterItem
import adeldolgov.emeter.databinding.FragmentCountersBinding
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
internal class CountersFragment :
    BindingMvpFragment<CountersPresenter, CountersView, FragmentCountersBinding>(),
    CountersView {

    private val countersAdapter: CountersAdapter = CountersAdapter { id -> }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCountersBinding
        get() = FragmentCountersBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        binding.countersRecycler.adapter = countersAdapter
        binding.swipeToRefreshView.setOnRefreshListener { castedPresenter().getCounters() }
    }

    override fun showLoader() {
        showLoading(true)
    }

    override fun showCounters(items: List<BaseItem>) {
        showLoading(false)
        // todo provide true header name
        countersAdapter.submitList(items.toMutableList().apply { add(0, HeaderCounterItem("Адель")) })
    }

    override fun showError(error: Throwable) {
        showLoading(false)
        requireContext().toast(error.message.toString())
    }

    private fun showLoading(show: Boolean) {
        binding.countersRecycler.isVisible = !show
        binding.countersLoadingView.shimmerLayout.isShimmering = show
        if (!show) binding.swipeToRefreshView.isRefreshing = false
    }

    override fun onAttach(context: Context) {
        CountersPresentationComponentHolder.get().inject(this)
        super.onAttach(context)
    }

    companion object {

        fun newInstance(): CountersFragment {
            return CountersFragment()
        }
    }
}