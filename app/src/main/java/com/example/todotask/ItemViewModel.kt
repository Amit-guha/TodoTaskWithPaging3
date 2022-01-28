package com.example.todoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    val  alldata : LiveData<PagingData<ItemName>>
    private val repository: ItemRepository

    init {
        val Dao = ItemDatabase.getdatabase(application).itemDao()
        repository= ItemRepository(Dao)
        //alldata=repository.readall

        alldata=Pager(
            PagingConfig(
                pageSize = 15,
                enablePlaceholders = true,
                maxSize = 100
            )
        )
        {
            Dao.readalldata()
        }.liveData.
        cachedIn(viewModelScope)
    }



    fun addnewItem(itemName: ItemName){
        viewModelScope.launch(Dispatchers.IO){
            repository.add(itemName)
        }
    }
}