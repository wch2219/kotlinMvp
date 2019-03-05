package com.example.kottlinbaselib.mvp.base

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kottlinbaselib.mvp.presenter.BasePresenter
import com.example.kottlinbaselib.mvp.view.IView

abstract class AbstractFragment<P:BasePresenter<IView>,V:IView>: Fragment(),ActivityMvpDelegateCallback<P,V>,IView {
    var mContent:Context?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var rootView = inflater.inflate(getLayoutId(),null)
        initView(rootView)
        initData()
        initlistener()
        return rootView
    }

    abstract fun initView(rootView: View?)

    abstract fun initData()

    fun initlistener(){}

    @SuppressLint("MissingSuperCall")
    override fun onAttach(context: Context?) {
        this.mContent = context
    }
    abstract fun getLayoutId(): Int
}