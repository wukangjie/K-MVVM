package com.example.appsimple.ui.data_lib

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.example.appsimple.ui.data_lib.data_store.DataStoreFragment
import com.example.appsimple.ui.data_lib.green_dao.GreenDaoFragment
import com.example.appsimple.ui.data_lib.mmkv.MmkvFragment
import com.example.appsimple.ui.data_lib.object_box.ObjectBoxFragment
import com.example.appsimple.ui.data_lib.sp.DataSpFragment
import com.example.appsimple.ui.main.MainAdapter
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_data_lib.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataLibFragment : BaseFragment() {

    companion object {
        fun newInstance() = DataLibFragment()
    }

    private  val mViewModel: DataLibViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.fragment_data_lib
    }

    override fun initView() {

        val spFragment = DataSpFragment.newInstance()
        val storeFragment = DataStoreFragment.newInstance()
        val mmkvFragment = MmkvFragment.newInstance()
        val objectBoxFragment = ObjectBoxFragment.newInstance()
        val greenDaoFragment = GreenDaoFragment.newInstance()

        loadMultipleRootFragment(R.id.content_frame,0, spFragment, storeFragment, mmkvFragment, objectBoxFragment, greenDaoFragment)
        recyclerView.layoutManager = LinearLayoutManager(_mActivity)

        val mAdapter = MainAdapter()
        val list = mutableListOf("SharePreference", "DataStore", "MMKV", "ObjectBox")

        mAdapter.setNewInstance(list)

        mAdapter.setOnItemClickListener { adapter, view, position ->
            when(position) {
                0-> {
                    showHideFragment(spFragment)
                }
                1->{
                    showHideFragment(storeFragment)
                }
                2 -> {
                    showHideFragment(mmkvFragment)
                }
                3 -> {
                    showHideFragment(objectBoxFragment)
                }
                4-> {
                    showHideFragment(greenDaoFragment)
                }
            }
        }

        recyclerView.adapter = mAdapter

    }

    override fun initData() {

    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {

    }

}