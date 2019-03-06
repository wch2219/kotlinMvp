package com.hg.kotlin.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainFragmentAdapter(fm: FragmentManager,fragments:List<Fragment>)
    : FragmentPagerAdapter(fm) {
   private var fragments:List<Fragment>?=null

    init {
        this.fragments = fragments
    }
    override fun getItem(position: Int): Fragment {

        return fragments?.get(position)!!
    }

    override fun getCount(): Int {
       return fragments?.size!!
    }
}