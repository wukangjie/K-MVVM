package com.example.appsimple.ui.data_lib.object_box

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appsimple.R
import com.example.appsimple.base.BaseFragment
import com.wukangjie.baselib.base.viewmodel.BaseViewModel
import io.objectbox.Box
import kotlinx.android.synthetic.main.fragment_object_box.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormat

class ObjectBoxFragment : BaseFragment() {

    companion object {
        fun newInstance() = ObjectBoxFragment()
    }

    private val mViewModel: ObjectBoxViewModel by viewModel()

    private lateinit var mAdapter: ObjectBoxAdapter

    private lateinit var userBox: Box<User>

    override fun getLayoutId(): Int {
        return R.layout.fragment_object_box
    }

    override fun initView() {
        userBox = ObjectBox.boxStore.boxFor(User::class.java)

        mAdapter = ObjectBoxAdapter()

        listViewNotes.adapter = mAdapter
        listViewNotes.layoutManager = LinearLayoutManager(_mActivity)
        mAdapter.setOnItemClickListener { _, _, position ->
            userBox.remove(mAdapter.getItem(position))
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
        val df =
            DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM)
        val user = User()
        user.name = noteText
        userBox.put(user)
    }

    override fun getViewModel(): BaseViewModel {
        return mViewModel
    }

    override fun createObserver() {
        mViewModel.getUserLiveData(userBox).observe(this, Observer {
            mAdapter.setNewInstance(it)
        })
    }


}