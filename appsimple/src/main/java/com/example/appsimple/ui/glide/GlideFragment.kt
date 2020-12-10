package com.example.appsimple.ui.glide

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_glide.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GlideFragment : BaseFragment() {

    companion object {
        fun newInstance() = GlideFragment()
    }

    private val  mViewModel: GlideViewModel by viewModel()


    override fun getLayoutId(): Int {
        return R.layout.fragment_glide
    }

    override fun initView() {

        recyclerView.layoutManager = LinearLayoutManager(_mActivity)
        val adapter = GlideAdapter()
        adapter.setNewInstance(mutableListOf(
            Type.Mask,
            Type.NinePatchMask,
            Type.RoundedCorners, Type.CropTop, Type.CropCenter,
            Type.CropBottom, Type.CropSquare, Type.CropCircle,
            Type.CropCircleWithBorder,
            Type.Grayscale, Type.BlurLight, Type.BlurDeep, Type.Toon, Type.Sepia,
            Type.Contrast, Type.Invert,
            Type.Pixel, Type.Sketch, Type.Swirl, Type.Brightness, Type.Kuawahara, Type.Vignette
        ))

        recyclerView.adapter = adapter

    }

    override fun initData() {

    }

    override fun getViewModel(): BaseViewModel {
       return mViewModel
    }

    override fun createObserver() {

    }

}