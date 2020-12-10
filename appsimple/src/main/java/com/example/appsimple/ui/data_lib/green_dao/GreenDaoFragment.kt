package com.example.appsimple.ui.data_lib.green_dao


import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsimple.R
import com.example.appsimple.base.App
import com.example.appsimple.base.BaseFragment
import com.example.appsimple.dao.UserDataDao
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.fragment_green_dao.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GreenDaoFragment : BaseFragment() {

    companion object {
        fun newInstance() = GreenDaoFragment()
    }

    private  val mViewModel: GreenDaoViewModel by viewModel()

    private lateinit var userDao: UserDataDao

    private lateinit var mAdapter: GreenDaoAdapter


    override fun getLayoutId(): Int {
        return R.layout.fragment_green_dao
    }

    override fun initView() {
        userDao = App.mDaoSession.userDataDao
        mAdapter = GreenDaoAdapter()

        listViewNotes.adapter = mAdapter
        listViewNotes.layoutManager = LinearLayoutManager(_mActivity)
        mAdapter.setOnItemClickListener { _, _, position ->
            userDao.delete(mAdapter.getItem(position))
        }



    }

    override fun initData() {
        buttonAdd.setOnClickListener {
            addNote()
        }
    }

    private fun addNote() {
        val noteText: String = editTextNote.text.toString()
        editTextNote.setText("")
        val user = UserData()
        user.name = noteText
        userDao.insertOrReplace(user)

        mAdapter.setNewInstance(userDao.loadAll())
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {

    }



}