package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(itemName: ItemName)


    @Query("SELECT * from ItemName ORDER BY Id")
    fun readalldata(): PagingSource<Int,ItemName>
}