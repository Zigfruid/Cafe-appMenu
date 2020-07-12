package com.example.fastfood.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.fastfood.data.ModelCafee.CafeMenu
import com.example.fastfood.data.dao.MenuDao



@Database(entities = [CafeMenu::class], version = 4)
abstract class MenuDB : RoomDatabase() {


    companion object{
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE `Cafee` (`id` INTEGER, `nameRus` TEXT, `details` TEXT, `ingredients` TEXT, `cost` TEXT, `isOrdered` INTEGER, " +
                        "PRIMARY KEY(`id`))")
            }
        }
        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Cafee ADD COLUMN quantity INTEGER")
            }
        }
    var INSTANCE: MenuDB? = null
        fun getInstance(context: Context) : MenuDB =
            Room.databaseBuilder(
                context,
                MenuDB::class.java,
                "menu-database.db"
            )

                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .createFromAsset("menu-database.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
   abstract fun dao():MenuDao

}