package com.example.appsimple.ui.data_lib.object_box

import com.example.appsimple.R
import com.wukangjie.baselib.base.adapter.CommonBaseAdapter
import com.wukangjie.baselib.base.adapter.CommonViewHolder

class ObjectBoxAdapter : CommonBaseAdapter<User>(R.layout.object_box_item) {
    override fun convert(holder: CommonViewHolder, item: User) {
        holder.setText(R.id.textViewNoteText, item.name)
            .setText(R.id.textViewNoteComment, item.id.toString())
    }
}