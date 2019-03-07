package com.hg.kotlin.ui.activitys

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kottlinbaselib.mvp.base.AbstractBaseActivity
import com.example.kottlinbaselib.mvp.presenter.BasePresenter
import com.example.kottlinbaselib.mvp.view.IView
import com.hg.kotlin.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AbstractBaseActivity<BasePresenter<IView>,IView>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
    }

    override fun getlayoutId(): Int {
        return R.layout.activity_animation
    }

    override fun initView() {
        var linearLayoutManager = LinearLayoutManager(mContext)
        rv_list.layoutManager = linearLayoutManager
//        rv_list.adapter =
    }

    override fun initData() {

    }
}
