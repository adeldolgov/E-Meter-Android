package adeldolgov.emeter.counters.presentation

import adeldolgov.emeter.common_ui.base.recyclerview.BaseItem
import adeldolgov.emeter.counters.presentation.adapter.CounterItem
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

internal interface CountersView : MvpView {

    @AddToEndSingle
    fun showLoader()

    @AddToEndSingle
    fun showCounters(items: List<BaseItem>)

    @AddToEndSingle
    fun showError(error: Throwable)
}