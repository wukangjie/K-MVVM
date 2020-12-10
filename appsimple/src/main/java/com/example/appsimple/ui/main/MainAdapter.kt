package com.example.appsimple.ui.main

import com.example.appsimple.R
import com.wukangjie.baselib.base.adapter.CommonBaseAdapter
import com.wukangjie.baselib.base.adapter.CommonViewHolder

class MainAdapter: CommonBaseAdapter<String>(R.layout.main_item) {
    override fun convert(holder: CommonViewHolder, item: String) {
        holder.setText(R.id.main_item, item)
    }
}