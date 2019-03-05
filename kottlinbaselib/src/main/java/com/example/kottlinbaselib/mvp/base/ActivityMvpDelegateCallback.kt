package com.example.kottlinbaselib.mvp.base


import com.example.kottlinbaselib.mvp.presenter.BasePresenter
import com.example.kottlinbaselib.mvp.view.IView

 interface ActivityMvpDelegateCallback<P : BasePresenter<IView>, V : IView>
    : BaseDelegateCallback<P, V>
