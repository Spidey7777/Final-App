package com.example.apirecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecycler.database.DatabaseEmployee
import com.example.apirecycler.databinding.EmployeeUnitBinding
import com.example.apirecycler.network.EmployeeDetails
import java.util.logging.Logger.global

class EmployeeListAdapter : ListAdapter<DatabaseEmployee, EmployeeListAdapter.EmployeeDetailsViewHolder>(DiffCallback) {
    class EmployeeDetailsViewHolder(private var binding: EmployeeUnitBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(employeeDetails: DatabaseEmployee) {
            binding.property = employeeDetails
            binding.executePendingBindings()
//            val genderIcon: Drawable
//            if (binding.property.gender == "male") {
//                genderIcon = R.drawable.man.toDrawable()
//            }
//            else {
//                genderIcon = R.drawable.woman.toDrawable()
//            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DatabaseEmployee>(){
        override fun areItemsTheSame(oldItem: DatabaseEmployee, newItem: DatabaseEmployee): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: DatabaseEmployee,
            newItem: DatabaseEmployee
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeListAdapter.EmployeeDetailsViewHolder {
        return EmployeeDetailsViewHolder(EmployeeUnitBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: EmployeeListAdapter.EmployeeDetailsViewHolder,
        position: Int
    ) {
        val employeeDetails = getItem(position)
        holder.bind(employeeDetails)
    }
}