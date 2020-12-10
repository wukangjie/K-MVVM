package com.example.appsimple.ui.data_lib.sp

import android.widget.Toast
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_data_sp.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataSpFragment : BaseFragment() {

    companion object {
        fun newInstance() = DataSpFragment()
    }

    private val mViewModel: DataSpViewModel by viewModel()



    override fun getLayoutId(): Int {
       return R.layout.fragment_data_sp
    }

    override fun initView() {
        updateSp.setOnClickListener {
            if (inputName.text.isBlank()) {
                Toast.makeText(_mActivity, "请输入名字", Toast.LENGTH_SHORT).show()
            } else {
                SpSetting.name = inputName.text.toString()
            }
        }

        querySp.setOnClickListener {
            inputName.setText(SpSetting.name)
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