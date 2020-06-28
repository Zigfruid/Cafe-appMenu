package com.example.fastfood.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.fastfood.data.ModelCafee.CafeMenu

@Dao
interface MenuDao {
    @Query("SELECT * FROM Cafee WHERE type =:type")
    fun getMenuByType(type: Int): List<CafeMenu>
}