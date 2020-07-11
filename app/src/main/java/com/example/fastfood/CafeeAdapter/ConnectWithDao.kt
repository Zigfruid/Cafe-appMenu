package com.example.fastfood.CafeeAdapter

import com.example.fastfood.data.ModelCafee.CafeMenu

interface ConnectWithDao {
    fun removeFromOrder(cafeMenu : CafeMenu)
}