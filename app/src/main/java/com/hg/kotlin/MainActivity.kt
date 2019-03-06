package com.hg.kotlin

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.kottlinbaselib.mvp.base.AbstractBaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hg.kotlin.mvp.presenter.MainPresenter
import com.hg.kotlin.mvp.view.MainView
import com.hg.kotlin.ui.adapter.MainFragmentAdapter
import com.hg.kotlin.ui.fragments.HomeFragment
import com.hg.kotlin.ui.fragments.MineFragment
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("UNUSED_EXPRESSION")
class MainActivity : AbstractBaseActivity<MainPresenter<MainView>, MainView>()
    ,BottomNavigationView.OnNavigationItemSelectedListener
    ,ViewPager.OnPageChangeListener
{
    private var fragments: MutableList<Fragment> = mutableListOf()
    override fun getlayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }


    override fun initData() {

        fragments.add(HomeFragment())
        fragments.add(MineFragment())
        fragments.add(HomeFragment())
        fragments.add(MineFragment())
        viewpage.adapter = MainFragmentAdapter(supportFragmentManager, fragments)
        viewpage.currentItem = 0
        viewpage.offscreenPageLimit = 4
    }
    override fun initListener() {
        bott_navi_view.setOnNavigationItemSelectedListener(this)
        viewpage.addOnPageChangeListener(this)

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.main_home//首页
            ->
                viewpage.currentItem = 0
            R.id.main_home1//频
            ->
                viewpage.currentItem = 1

            R.id.main_home2 ->

                viewpage.currentItem = 2

            R.id.main_home3//我的
            ->
                viewpage.currentItem = 3
        }

        return  true
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        when(position){
            0 ->
                bott_navi_view.selectedItemId = R.id.main_home
            1 ->
                bott_navi_view.selectedItemId = R.id.main_home1
            2 ->
                bott_navi_view.selectedItemId = R.id.main_home2
            3 ->
                bott_navi_view.selectedItemId = R.id.main_home3

        }
    }
}
