package com.example.todotask

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.todoapp.ItemDao
import com.example.todoapp.ItemName

class ItemPagingSource(
    private val itemDao: ItemDao
) : PagingSource<Int, ItemName>() {
    override fun getRefreshKey(state: PagingState<Int, ItemName>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemName> {
        TODO("Not yet implemented")
    }

}