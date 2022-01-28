package com.example.todoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ItemName::class],version = 1,exportSchema = false)
abstract class ItemDatabase : RoomDatabase(){
    abstract fun itemDao() : ItemDao

    companion object {
        @Volatile
        private var INSTNCE: ItemDatabase? = null


        fun getdatabase(context: Context): ItemDatabase {
            val temp = INSTNCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "ItemName"
                ).build()
                INSTNCE = instance
                return instance
            }
        }
    }
}