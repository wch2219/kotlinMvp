package com.hg.kotlin.ui.fragments


import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kottlinbaselib.mvp.base.AbstractFragment
import com.hg.kotlin.R
import com.hg.kotlin.mvp.presenter.MainPresenter
import com.hg.kotlin.mvp.view.MainView
import com.hg.kotlin.ui.activitys.AnimationActivity


/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : AbstractFragment<MainPresenter<MainView>, MainView>(), View.OnClickListener {
    var button:Button ?= null

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView(rootView: View?) {
       this.button = rootView?.findViewById(R.id.button1)!!

    }

    override fun initData() {
    }

    override fun initlistener() {
        this.button?.setOnClickListener(this::onClick)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
                var intent = Intent()
                intent.setClass(mContext,AnimationActivity().javaClass)
                startActivity(intent)
            }
        }
    }
}


