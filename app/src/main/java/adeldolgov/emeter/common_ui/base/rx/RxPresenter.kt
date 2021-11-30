package adeldolgov.emeter.common_ui.base.rx

import adeldolgov.emeter.common_ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpView

abstract class RxPresenter<V: MvpView> : BasePresenter<V>() {
    private val disposables = CompositeDisposable()

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }

    protected fun removeDisposable(disposable: Disposable?) {
        disposable?.let {
            disposables.remove(it)
        }
    }

    protected fun Disposable.disposeOnFinish(): Disposable {
        disposables += this
        return this
    }

    protected fun dispose(disposable: Disposable) {
        if (!disposables.remove(disposable)) {
            disposable.dispose()
        }
    }

    private operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        add(disposable)
    }
}