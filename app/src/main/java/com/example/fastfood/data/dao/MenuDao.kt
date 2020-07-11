package com.example.fastfood.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.fastfood.data.ModelCafee.CafeMenu

@Dao
interface MenuDao {
    @Query("SELECT * FROM Cafee WHERE type =:type")
    fun getMenuByType(type: Int): List<CafeMenu>

    @Query("SELECT * FROM Cafee WHERE id = :id")
    fun getMenuById(id: Int) : CafeMenu


    @Update
    fun update(menu: CafeMenu)

    @Query("SELECT * FROM Cafee WHERE isOrdered=1")
    fun getAllFromIsOrdered() : List<CafeMenu>



}