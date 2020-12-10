package com.example.appsimple.ui.glide

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PointF
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.appsimple.R
import com.wukangjie.baselib.base.adapter.CommonBaseAdapter
import com.wukangjie.baselib.base.adapter.CommonViewHolder
import com.wukangjie.baselib.util.DensityUtils.dp2px
import com.wukangjie.baselib.util.GlideUtils.loadCircleImage
import com.wukangjie.baselib.util.GlideUtils.loadCornerImage
import jp.wasabeef.glide.transformations.*
import jp.wasabeef.glide.transformations.gpu.*

class GlideAdapter : CommonBaseAdapter<Type>(R.layout.glide_item) {
    override fun convert(holder: CommonViewHolder, item: Type) {

        val image: ImageView = holder.getView(R.id.image)
        holder.setText(R.id.title, item.name)

        when (item) {
            Type.Mask -> {
                Glide.with(context)
                    .load(R.drawable.check)
                    .apply(RequestOptions.overrideOf(266.dp2px(), 252.dp2px()))
                    .apply(
                        RequestOptions.bitmapTransform(
                            MultiTransformation<Bitmap>(
                                CenterCrop(),
                                MaskTransformation(R.drawable.mask_starfish)
                            )
                        )
                    )
                    .into(image)
            }
            Type.NinePatchMask -> {
                Glide.with(context)
                    .load(R.drawable.check)
                    .apply(RequestOptions.overrideOf(300.dp2px(), 200.dp2px()))
                    .apply(
                        RequestOptions.bitmapTransform(
                            MultiTransformation<Bitmap>(
                                CenterCrop(),
                                MaskTransformation(R.drawable.mask_chat_right)
                            )
                        )
                    )
                    .into(image)
            }

            Type.CropTop -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(
                    RequestOptions.bitmapTransform(
                        CropTransformation(
                            300.dp2px(),
                            100.dp2px(),
                            CropTransformation.CropType.TOP
                        )
                    )
                )
                .into(image)

            Type.CropCenter -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(
                    RequestOptions.bitmapTransform(
                        CropTransformation(
                            300.dp2px(),
                            100.dp2px(),
                            CropTransformation.CropType.CENTER
                        )
                    )
                )
                .into(image)

            Type.CropBottom -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(
                    RequestOptions.bitmapTransform(
                        CropTransformation(
                            300.dp2px(),
                            100.dp2px(),
                            CropTransformation.CropType.BOTTOM
                        )
                    )
                )
                .into(image)

            Type.CropSquare -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(RequestOptions.bitmapTransform(CropSquareTransformation()))
                .into(image)

            Type.CropCircle -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(RequestOptions.bitmapTransform(CropCircleTransformation()))
                .into(image)

            Type.CropCircleWithBorder -> image.loadCircleImage(context, R.drawable.demo, 10)

            Type.ColorFilter -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(
                    RequestOptions.bitmapTransform(
                        ColorFilterTransformation(
                            Color.argb(
                                80,
                                255,
                                0,
                                0
                            )
                        )
                    )
                )
                .into(image)

            Type.Grayscale -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(RequestOptions.bitmapTransform(GrayscaleTransformation()))
                .into(image)

            Type.RoundedCorners ->
                image.loadCornerImage(context, R.drawable.demo, 4)

            Type.BlurLight -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(25)))
                .into(image)

            Type.BlurDeep -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 8)))
                .into(image)

            Type.Toon -> Glide.with(context)
                .load(R.drawable.demo)
                .apply(RequestOptions.bitmapTransform(ToonFilterTransformation()))
                .into(image)

            Type.Sepia -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(SepiaFilterTransformation()))
                .into(image)

            Type.Contrast -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(ContrastFilterTransformation(2.0f)))
                .into(image)

            Type.Invert -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(InvertFilterTransformation()))
                .into(image)

            Type.Pixel -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(PixelationFilterTransformation(20f)))
                .into(image)

            Type.Sketch -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(SketchFilterTransformation()))
                .into(image)

            Type.Swirl -> Glide.with(context)
                .load(R.drawable.check)
                .apply(
                    RequestOptions.bitmapTransform(
                        SwirlFilterTransformation(0.5f, 1.0f, PointF(0.5f, 0.5f))
                    ).dontAnimate()
                )
                .into(image)

            Type.Brightness -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(BrightnessFilterTransformation(0.5f)).dontAnimate())
                .into(image)

            Type.Kuawahara -> Glide.with(context)
                .load(R.drawable.check)
                .apply(RequestOptions.bitmapTransform(KuwaharaFilterTransformation(25)).dontAnimate())
                .into(image)

            Type.Vignette -> Glide.with(context)
                .load(R.drawable.check)
                .apply(
                    RequestOptions.bitmapTransform(
                        VignetteFilterTransformation(
                            PointF(0.5f, 0.5f),
                            floatArrayOf(0.0f, 0.0f, 0.0f), 0f, 0.75f
                        )
                    ).dontAnimate()
                )
                .into(image)
        }

    }
}

enum class Type {
    Mask,
    NinePatchMask,
    CropTop,
    CropCenter,
    CropBottom,
    CropSquare,
    CropCircle,
    CropCircleWithBorder,
    ColorFilter,
    Grayscale,
    RoundedCorners,
    BlurLight,
    BlurDeep,
    Toon,
    Sepia,
    Contrast,
    Invert,
    Pixel,
    Sketch,
    Swirl,
    Brightness,
    Kuawahara,
    Vignette,
}