package com.example.apirecycler

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecycler.database.DatabaseEmployee
import com.example.apirecycler.network.EmployeeDetails

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DatabaseEmployee>?) {
    val adapter = recyclerView.adapter as EmployeeListAdapter
    adapter.submitList(data)
}