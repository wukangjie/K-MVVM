package com.wukangjie.baselib.base.adapter

import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule

abstract class CommonBaseAdapter<T>(@LayoutRes layoutRes: Int) : BaseQuickAdapter<T, CommonViewHolder>(layoutRes), LoadMoreModule