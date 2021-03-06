package com.example.kottlinbaselib.mvp.base

import android.content.Context
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.kottlinbaselib.mvp.presenter.BasePresenter
import com.example.kottlinbaselib.mvp.view.IView

@Suppress("UNCHECKED_CAST")
abstract class AbstractBaseActivity<P : BasePresenter<IView>, V : IView> : AppCompatActivity()
    , ActivityMvpDelegateCallback<P, V>, IView {
    private var mPresenter: P? = null
    open var mContext:Context ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter?.attachView(getMvpView())
        setContentView(getlayoutId())
        mContext = this
        mPresenter = createPresenter()
        initView()
        initData()
        initListener()
    }

    abstract fun getlayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    open fun initListener() {}


    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun onError(mess: String?) {

    }

    override fun showDialog(mess: String?, code: Int) {

    }

    override fun getPresenter(): P? {

        return mPresenter
    }

    override fun getMvpView(): V {

        return this as V
    }

    override fun createPresenter(): P? {

        return null
    }

    override fun onDestroy() {
        mPresenter?.detachView()
        super.onDestroy()
    }
}