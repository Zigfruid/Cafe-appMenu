package com.example.fastfood.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastfood.CafeeAdapter.ChildAdapter
import com.example.fastfood.CafeeAdapter.MainAdapter
import com.example.fastfood.MVP.MenuViewHelper
import com.example.fastfood.MVP.Presenter
import com.example.fastfood.R
import com.example.fastfood.data.MenuDB
import com.example.fastfood.data.ModelCafee.CafeMenu
import com.example.fastfood.data.ModelCafee.MenuClickListener
import com.example.fastfood.data.dao.MenuDao
import com.example.fastfood.ui.DetailActivity
import kotlinx.android.synthetic.main.order_fragment.*

class OrderFragment: Fragment(R.layout.order_fragment) , MenuViewHelper, MenuClickListener {

    private val mAdapter =  ChildAdapter(this)
    private lateinit var dao: MenuDao
    private lateinit var presenter: Presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_order.adapter = mAdapter
        rv_order.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        dao = MenuDB.INSTANCE!!.dao() //ghjkl;'ffff

    }

    override fun onStart() {
        presenter = Presenter(dao , this)
        presenter.getMenuFromOrder()//dddd
        super.onStart()
    }

    override fun fillData(models: List<CafeMenu>) {
        mAdapter.item = models
    }

    override fun onItemMenuClickListener(id: Int) {
            val mIntent = Intent(requireActivity(), DetailActivity::class.java)
            mIntent.putExtra(DetailActivity.MENU_ID, id)
            startActivity(mIntent)
    }
}