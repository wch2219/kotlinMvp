package com.example.kottlinbaselib.mvp.base

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.kottlinbaselib.mvp.presenter.BasePresenter
import com.example.kottlinbaselib.mvp.view.IView

@Suppress("UNCHECKED_CAST")
abstract class AbstractBaseActivity<P : BasePresenter<IView>, V : IView> : AppCompatActivity()
    , ActivityMvpDelegateCallback<P, V>, IView {
    private var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter?.attachView(getMvpView())
        setContentView(getlayoutId())
        mPresenter = createPresenter()
        initView()
        initData()
        initListener()
    }

    abstract fun getlayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    fun initListener() {}


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