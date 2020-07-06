package com.example.fastfood.MVP

import com.example.fastfood.data.ModelCafee.CafeMenu

interface MenuView {
    fun fillData(models:List<CafeMenu>)

}