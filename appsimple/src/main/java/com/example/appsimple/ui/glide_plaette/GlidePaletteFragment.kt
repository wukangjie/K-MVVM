package com.example.appsimple.ui.glide_plaette

import android.graphics.drawable.Drawable
import androidx.annotation.Nullable
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.github.florent37.glidepalette.BitmapPalette

import com.github.florent37.glidepalette.GlidePalette
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_glide_palette.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GlidePaletteFragment : BaseFragment() {

    companion object {
        fun newInstance() = GlidePaletteFragment()
    }

    private val mViewModel: GlidePaletteViewModel by viewModel()

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_glide_palette
    }

    override fun initView() {
        Glide.with(this).load(R.drawable.check)
            .listener(
                GlidePalette.with(R.drawable.check.toString())
                    .use(BitmapPalette.Profile.VIBRANT)
                    .intoBackground(textVibrant, BitmapPalette.Swatch.RGB)
                    .intoTextColor(textVibrant, BitmapPalette.Swatch.BODY_TEXT_COLOR)
                    .crossfade(true)
                    .use(BitmapPalette.Profile.VIBRANT_DARK)
                    .intoBackground(textVibrantDark, BitmapPalette.Swatch.RGB)
                    .intoTextColor(textVibrantDark, BitmapPalette.Swatch.BODY_TEXT_COLOR)
                    .crossfade(false)
                    .use(BitmapPalette.Profile.VIBRANT_LIGHT)
                    .intoBackground(textVibrantLight, BitmapPalette.Swatch.RGB)
                    .intoTextColor(textVibrantLight, BitmapPalette.Swatch.BODY_TEXT_COLOR)
                    .crossfade(true, 1000)
                    .use(BitmapPalette.Profile.MUTED)
                    .intoBackground(textMuted, BitmapPalette.Swatch.RGB)
                    .intoTextColor(textMuted, BitmapPalette.Swatch.BODY_TEXT_COLOR)
                    .use(BitmapPalette.Profile.MUTED_DARK)
                    .intoBackground(textMutedDark, BitmapPalette.Swatch.RGB)
                    .intoTextColor(textMutedDark, BitmapPalette.Swatch.BODY_TEXT_COLOR)
                    .crossfade(true, 2000)
                    .use(BitmapPalette.Profile.MUTED_LIGHT)
                    .intoBackground(textMutedLight, BitmapPalette.Swatch.RGB)
                    .intoTextColor(textMutedLight, BitmapPalette.Swatch.BODY_TEXT_COLOR) // optional
                    .intoCallBack(object : BitmapPalette.CallBack {
                        override fun onPaletteLoaded(@Nullable palette: Palette?) {
                            //specific task
                        }
                    }) // optional
                    .setGlideListener(object : RequestListener<Drawable?> {


                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable?>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                        return false
                        }
                    }) // optional: do stuff with the builder
                    .setPaletteBuilderInterceptor { builder -> builder.resizeBitmapArea(300 * 100) }
            )
            .into(image)
    }

    override fun initData() {

    }

}