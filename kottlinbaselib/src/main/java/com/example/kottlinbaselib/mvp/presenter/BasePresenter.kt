package com.example.kottlinbaselib.mvp.presenter

import com.example.kottlinbaselib.mvp.view.IView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V : IView> : IPresenter<V> {

    var mView: V? = null
        private set

    private var compositeDisposable = CompositeDisposable()
    override fun attachView(mRootView: V) {
        this.mView = mRootView
    }

    override fun detachView() {
        this.mView = null
        //保证activity结束时取消所有正在执行的订阅
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }


    private val isViewAttached: Boolean
        get() = mView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }


    private class MvpViewNotAttachedException internal constructor() :
        RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")
}