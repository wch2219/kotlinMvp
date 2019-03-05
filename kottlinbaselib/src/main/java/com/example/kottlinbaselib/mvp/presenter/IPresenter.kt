package com.example.kottlinbaselib.mvp.presenter

import com.example.kottlinbaselib.mvp.view.IView

 interface IPresenter<in V : IView> {

    fun attachView(mRootView: V)

    fun detachView()

}