package com.example.fastfood.MVP

import com.example.fastfood.data.MenuDB
import com.example.fastfood.data.dao.MenuDao

class Presenter(private val dao: MenuDao, private val view : MenuViewHelper) {

    fun getAllMenu(type: Int) {
        view.fillData(MenuDB.INSTANCE!!.dao().getMenuByType(type))
    }
        fun  getMenuFromOrder(){
        view.fillData(MenuDB.INSTANCE!!.dao().getOrderFromMenu())

        }

}