package com.example.todotask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.ItemAdapter
import com.example.todoapp.ItemName

class NewAdapter : PagingDataAdapter<ItemName, NewAdapter.NewViewHolder>(PHOTO_COMPARATOR) {
   // private var userlist = emptyList<ItemName>()
    class NewViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val taskname: TextView = itemview.findViewById(R.id.tv_task)
        val liner : LinearLayout =itemview.findViewById(R.id.lay)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<ItemName>() {
            override fun areItemsTheSame(oldItem: ItemName, newItem: ItemName) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ItemName, newItem: ItemName) =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {

        val currentitem = getItem(position)
       // val currentitem = userlist[position]
        holder.apply {
            taskname.text = currentitem?.namesItem

            liner.setOnClickListener {
                liner.setBackgroundResource(R.drawable.check)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val itemview =
            LayoutInflater.from(parent.context).inflate(R.layout.databaseshow, parent, false)
        return NewViewHolder(itemview)
    }


}