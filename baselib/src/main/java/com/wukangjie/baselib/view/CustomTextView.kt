package com.wukangjie.baselib.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.noober.background.BackgroundFactory
import com.wukangjie.baselib.R

class CustomTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr) {

    private var isBold = false

    private fun obtainAttributes(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        isBold = ta.getBoolean(R.styleable.CustomTextView_isBold, false)
        ta.recycle()
    }

    /**
     * 设置字体是否为粗体
     *
     * @param bold
     */
    fun setBold(bold: Boolean) {
        isBold = bold
        setTextBold()
    }

    private fun setTextBold() {
        paint.isFakeBoldText = isBold
        invalidate()
    }

    private fun initView() {}

    init {
        initView()
        obtainAttributes(context, attrs)
        BackgroundFactory.setViewBackground(context, attrs, this)
        setTextBold()
    }
}