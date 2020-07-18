package com.example.fastfood.MVP

import com.example.fastfood.data.dao.MenuDao

class Presenter(private val dao: MenuDao, private val view : MenuViewHelper) {

    fun  getMenuFromOrder(){
        view.fillData(dao.getAllFromIsOrdered())
        }
}