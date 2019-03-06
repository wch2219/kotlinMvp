package com.example.kottlinbaselib.mvp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kottlinbaselib.mvp.presenter.BasePresenter
import com.example.kottlinbaselib.mvp.view.IView

@Suppress("UNCHECKED_CAST")
abstract class AbstractFragment<P : BasePresenter<IView>, V : IView> : Fragment(), ActivityMvpDelegateCallback<P, V>,
    IView {
    var mContent: Context? = null
    private var mPresenter: P? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mPresenter = createPresenter()
        var rootView = inflater.inflate(getLayoutId(), null)
        initView(rootView)
        initData()
        initlistener()
        return rootView
    }

    abstract fun getLayoutId(): Int
    abstract fun initView(rootView: View?)

    abstract fun initData()

    fun initlistener() {}

    override fun getPresenter(): P? {
        return mPresenter
    }

    override fun getMvpView(): V {
        return this as V
    }

    override fun createPresenter(): P? {
        return null
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(mess: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDialog(mess: String?, code: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}