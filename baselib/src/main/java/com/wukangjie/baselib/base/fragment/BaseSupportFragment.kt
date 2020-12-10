package com.wukangjie.baselib.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.wukangjie.baselib.util.LogUtils
import me.yokeyword.fragmentation.SupportFragment

abstract class BaseSupportFragment : SupportFragment() {


    var mView: View? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogUtils.trace<Any>(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.trace<Any>(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtils.trace<Any>(this)
        mView = inflater.inflate(getLayoutId(), container, false)

        return mView
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    override fun onStart() {
        super.onStart()
        LogUtils.trace<Any>(this)
    }

    override fun onResume() {
        super.onResume()
        LogUtils.trace<Any>(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        initData()
    }

    override fun onPause() {
        super.onPause()
        LogUtils.trace<Any>(this)

    }

    override fun onStop() {
        super.onStop()
        LogUtils.trace<Any>(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.trace<Any>(this)
    }

    override fun onDetach() {
        super.onDetach()
        LogUtils.trace<Any>(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.trace<Any>(this)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        LogUtils.trace<Any>(this)
    }

    companion object {

        private const val STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN"
    }
}