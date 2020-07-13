package com.example.fastfood.MVP

import com.example.fastfood.data.MenuDB
import com.example.fastfood.data.dao.MenuDao

class Presenter(private val dao: MenuDao, private val view : MenuViewHelper) {

    fun getAllMenu(type: Int) {
        view.fillData(dao.getMenuByType(type))
    }
        fun  getMenuFromOrder(){
        view.fillData(dao.getOrderFromMenu())
           // MenuDB.INSTANCE!!.dao().getOrderFromMenu()
        }

}