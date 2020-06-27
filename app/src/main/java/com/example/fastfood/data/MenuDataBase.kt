package com.example.fastfood.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fastfood.data.ModelCafee.MenuCafe
import com.example.fastfood.data.dao.CafeDao

@Database(entities = [MenuCafe::class], version = 2)
abstract class MenuDataBase : RoomDatabase() {

    companion object{
        private lateinit var INSTANCE: MenuDataBase

        fun getInstance(context: Context): MenuDataBase =
            Room.databaseBuilder(
                context,
                MenuDataBase::class.java,
                "menu-database.db"
            )
                .createFromAsset("menu-database.db")
                .allowMainThreadQueries()
                .build()
    }

    abstract fun dao(): CafeDao
}