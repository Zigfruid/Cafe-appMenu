package com.example.fastfood.MenuRecycleFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fastfood.CafeeAdapter.MainAdapter
import com.example.fastfood.Fragments.HomeFragment
import com.example.fastfood.R
import com.example.fastfood.data.MenuDB
import com.example.fastfood.data.dao.MenuDao
import kotlinx.android.synthetic.main.fragment_recycler.*

class FragmentMenu : Fragment(R.layout.fragment_recycler) {

    private val mAdapter = MainAdapter()
    lateinit var dao: MenuDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv1.adapter = mAdapter
        val type = arguments?.getInt(HomeFragment.TYPE_ID) ?:1
        dao = MenuDB.getInstance(requireContext()).dao()
        fillData(type)
    }
    private fun fillData(type: Int){
        Log.d("modeller", dao.getMenuByType(type).toString())
        mAdapter.item = dao.getMenuByType(type)
    }

}