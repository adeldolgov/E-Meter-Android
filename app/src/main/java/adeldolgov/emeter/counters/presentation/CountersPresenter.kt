package adeldolgov.emeter.counters.presentation

import adeldolgov.emeter.common_ui.base.rx.RxPresenter
import adeldolgov.emeter.counters.domain.usecase.GetCountersUseCase
import adeldolgov.emeter.counters.presentation.adapter.CounterToItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/*
*@author Adel Dolgov on 28,Ноябрь,2021
*/
internal class CountersPresenter @Inject constructor(
    private val getCountersUseCase: GetCountersUseCase,
    private val counterToItemMapper: CounterToItemMapper,
) : RxPresenter<CountersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getCounters()
    }

    fun getCounters() {
        getCountersUseCase()
            .map(counterToItemMapper)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.showLoader() }
            .subscribeBy(
                onNext = { viewState.showCounters(it) },
                onError = { viewState.showError(it) }
            ).disposeOnFinish()
    }
}