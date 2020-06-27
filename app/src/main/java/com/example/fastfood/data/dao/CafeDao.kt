package com.example.fastfood.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.fastfood.data.ModelCafee.MenuCafe


@Dao
interface CafeDao {
    @Query("SELECT * FROM Cafee WHERE type = :type")
    fun getAllOfMenu(type: Int): List<MenuCafe>
}