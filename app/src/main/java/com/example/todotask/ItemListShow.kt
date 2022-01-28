package com.example.todoapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todotask.NewAdapter
import com.example.todotask.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class ItemListShow : Fragment(R.layout.itemlistshow) {

    private val viewModel: ItemViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)

        recyclerView = v.findViewById(R.id.recycler_item)
        floatingActionButton = v.findViewById(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_itemListShow_to_itemAdd4)
        }

        val adapter = NewAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)


        lifecycleScope.launch {
            adapter.refresh()

            viewModel.alldata.observe(viewLifecycleOwner, Observer {
                adapter.refresh()
                adapter.submitData(viewLifecycleOwner.lifecycle, it)


            })
        }


    }
}