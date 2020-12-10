package com.wukangjie.baselib.util

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.wukangjie.baselib.util.DensityUtils.dp2px
import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation
import jp.wasabeef.glide.transformations.CropSquareTransformation

object GlideUtils {


    /**
     * 加载本地图片
     *
     * @param context
     * @param drawableId
     */
    fun ImageView.loadImage(context: Context = this.context, @RawRes @DrawableRes drawableId: Int) {
        Glide.with(context)
            .load(drawableId)
            .into(this)
    }


    /**
     * 加载圆角图片
     */

    fun ImageView.loadCornerImage(context: Context = this.context, url: String, radius: Int) {
        Glide.with(context).load(url)
            .apply(initOptions(MultiTransformation(CenterCrop(), RoundedCorners(radius.dp2px()))))
            .transition(withCrossFade())
            .into(this)
    }

    fun ImageView.loadCornerImage(context: Context = this.context, @RawRes @DrawableRes drawableId: Int, radius: Int) {
        Glide.with(context)
            .load(drawableId)
            .apply(initOptions(MultiTransformation(CenterCrop(), RoundedCorners(radius.dp2px()))))
            .transition(withCrossFade())
            .into(this)
    }

    /**
     * 加载带边框圆形图片
     */
    fun ImageView.loadCircleImage(context: Context = this.context, url: String?, borderSize: Int = 0) {
        Glide.with(context)
            .load(url)
            .circleCrop()
            .apply(
                initOptions(
                    CropCircleWithBorderTransformation(
                        borderSize,
                        ContextCompat.getColor(context, android.R.color.black)
                    )
                )
            )
            .transition(withCrossFade())
            .into(this)
    }

    fun ImageView.loadCircleImage(context: Context = this.context, @RawRes @DrawableRes drawableId: Int, borderSize: Int = 1) {
        Glide.with(context)
            .load(drawableId)
            .apply(
                initOptions(
                    CropCircleWithBorderTransformation(
                        borderSize,
                        ContextCompat.getColor(context, android.R.color.black)
                    )
                )
            )
            .transition(withCrossFade())
            .into(this)
    }


    /**
     * 加载正方形图片
     */

    fun ImageView.loadSquareImage(context: Context = this.context, url: String?) {
        Glide.with(context)
            .load(url)
            .centerCrop()
            .apply(initOptions(CropSquareTransformation()))
            .transition(withCrossFade())
            .into(this)
    }


    /**
     * @return 这里默认设置全部为禁止缓存
     * @describe 设置缓存
     * Glide有两种缓存机制，一个是内存缓存，一个是硬盘缓存。
     * 内存缓存的主要作用是防止应用重复将图片数据读取到内存当中，
     * 而硬盘缓存的主要作用是防止应用重复从网络或其他地方重复下载和读取数据
     * @diskCacheStrategy参数 DiskCacheStrategy.NONE： 表示不缓存任何内容
     * DiskCacheStrategy.DATA： 表示只缓存原始图片
     * DiskCacheStrategy.RESOURCE： 表示只缓存转换过后的图片
     * DiskCacheStrategy.ALL ： 表示既缓存原始图片，也缓存转换过后的图片
     * DiskCacheStrategy.AUTOMATIC： 表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）
     */
    private fun initOptions(transformation: Transformation<Bitmap>): RequestOptions {
        return RequestOptions()
            .transform(transformation)
            .skipMemoryCache(false) //是否允许内存缓存
            .placeholder(android.R.color.transparent)
            .error(android.R.color.black)
            .onlyRetrieveFromCache(false) //是否只从缓存加载图片
            .diskCacheStrategy(DiskCacheStrategy.ALL) //禁止磁盘缓存
    }


}