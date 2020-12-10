package com.wukangjie.baselib.util

import android.content.Context
import android.content.res.Resources

object DensityUtils {

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    fun Float.dp2px(): Float {
        val scale = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f)
    }

    fun Int.dp2px(): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun Float.px2dp(): Float {
        val scale = Resources.getSystem().displayMetrics.density
        return (this / scale + 0.5f)
    }

    fun Int.px2dp(): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (this / scale + 0.5f).toInt()
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    fun Float.dp2sp(): Float {
        val fontScale = Resources.getSystem().displayMetrics.scaledDensity
        return (this / fontScale + 0.5f)
    }

    fun Int.dp2sp(): Int {
        val fontScale = Resources.getSystem().displayMetrics.scaledDensity
        return (this / fontScale + 0.5f).toInt()
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    fun Float.sp2px(): Int {
        val fontScale = Resources.getSystem().displayMetrics.scaledDensity
        return (this * fontScale + 0.5f).toInt()
    }

    fun getWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels

    }

    fun getHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    fun getStatusBarHeight(context: Context): Int {
        val resources = context.resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

}