package com.hg.kotlin.ui.fragments


import android.view.View
import androidx.fragment.app.Fragment
import com.example.kottlinbaselib.mvp.base.AbstractFragment
import com.hg.kotlin.R
import com.hg.kotlin.mvp.presenter.MainPresenter
import com.hg.kotlin.mvp.view.MainView


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : AbstractFragment<MainPresenter<MainView>,MainView>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(rootView: View?) {

    }

    override fun initData() {
    }

}
