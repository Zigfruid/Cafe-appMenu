package com.example.fastfood.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fastfood.data.ModelCafee.CafeMenu
import com.example.fastfood.data.dao.MenuDao

@Database(entities = [CafeMenu::class], version = 3)
abstract class MenuDB : RoomDatabase() {
    companion object{
        private lateinit var INSTANCE: MenuDB
        fun getInstance(context: Context) : MenuDB =
            Room.databaseBuilder(
                context,
                MenuDB::class.java,
                "menu-database.db"

            )
                .createFromAsset("menu-database.db")
                .allowMainThreadQueries()
                .build()
    }
   abstract fun dao():MenuDao
}