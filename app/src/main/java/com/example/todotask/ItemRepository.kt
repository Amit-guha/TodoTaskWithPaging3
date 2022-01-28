package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource

class ItemRepository(private val itemDao: ItemDao)  {

    val readall: PagingSource<Int, ItemName> = itemDao.readalldata()

    suspend fun add(itemName: ItemName){
        itemDao.addItem(itemName)
    }
}