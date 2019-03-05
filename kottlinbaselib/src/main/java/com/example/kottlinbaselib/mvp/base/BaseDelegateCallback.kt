package com.example.kottlinbaselib.mvp.base


import com.example.kottlinbaselib.mvp.presenter.IPresenter
import com.example.kottlinbaselib.mvp.view.IView

  interface BaseDelegateCallback<P : IPresenter<V>, V : IView> {


    fun getPresenter(): P?

    fun getMvpView(): V

    fun createPresenter(): P?
}
