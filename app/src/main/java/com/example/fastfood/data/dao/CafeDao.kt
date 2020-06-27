package com.example.fastfood.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.fastfood.data.ModelCafee.CafeMenu


@Dao
interface CafeDao {
    @Query("SELECT *FROM menu")
    fun getAllOfMenu(): List<CafeMenu>
}