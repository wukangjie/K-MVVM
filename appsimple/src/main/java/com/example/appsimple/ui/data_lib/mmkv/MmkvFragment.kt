package com.example.appsimple.ui.data_lib.mmkv

import android.widget.Toast
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.tencent.mmkv.MMKV
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_data_sp.inputName
import kotlinx.android.synthetic.main.fragment_data_sp.querySp
import kotlinx.android.synthetic.main.fragment_data_sp.updateSp
import kotlinx.android.synthetic.main.fragment_mmkv.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MmkvFragment : BaseFragment() {

    companion object {
        fun newInstance() = MmkvFragment()
    }

    private val mViewModel: MmkvViewModel by viewModel()

    override fun getLayoutId(): Int {
       return R.layout.fragment_mmkv
    }

    override fun initView() {
        val mmkv = MMKV.defaultMMKV()
        updateSp.setOnClickListener {
            if (inputName.text.isBlank()) {
                Toast.makeText(_mActivity, "请输入名字", Toast.LENGTH_SHORT).show()
            } else {
                mmkv.encode("name", inputName.text.toString())
                mmkv.apply()
            }
        }

        querySp.setOnClickListener {
            inputName.setText(mmkv.decodeString("name"))
        }

        deleteSp.setOnClickListener {
            mmkv.remove("name")
        }

    }

    override fun initData() {

    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {

    }

}