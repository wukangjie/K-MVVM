package com.example.appsimple.ui.data_lib.green_dao

import com.example.appsimple.R
import com.wukangjie.baselib.base.adapter.CommonBaseAdapter
import com.wukangjie.baselib.base.adapter.CommonViewHolder

class GreenDaoAdapter : CommonBaseAdapter<UserData>(R.layout.object_box_item) {
    override fun convert(holder: CommonViewHolder, item: UserData) {
        holder.setText(R.id.textViewNoteText, item.name)
            .setText(R.id.textViewNoteComment, item.content)
    }
}