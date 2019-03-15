package com.example.kottlinbaselib.utils

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager

object DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun sp2px(context: Context, sp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp.toFloat(), context.resources.displayMetrics)
            .toInt()
    }

    fun getSereenW(context: Context): Int {

        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        wm.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels         // 屏幕宽度（像素）
        val height = dm.heightPixels       // 屏幕高度（像素）

        return width
    }

    fun dp2px(dp: Float): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }

}
