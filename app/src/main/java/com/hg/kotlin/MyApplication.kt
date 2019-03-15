package com.hg.kotlin

import android.app.Application
import com.example.kottlinbaselib.utils.SPUtils

class MyApplication :Application(){

    override fun onCreate() {
        super.onCreate()

        SPUtils.instance(applicationContext)
    }
}