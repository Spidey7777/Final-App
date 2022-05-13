package com.example.apirecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apirecycler.databinding.EmployeeUnitBinding
import com.example.apirecycler.network.EmployeeDetails
import java.util.logging.Logger.global

class EmployeeListAdapter : ListAdapter<EmployeeDetails, EmployeeListAdapter.EmployeeDetailsViewHolder>(DiffCallback) {
    class EmployeeDetailsViewHolder(private var binding: EmployeeUnitBinding) : RecyclerView.ViewHolder(binding.root){
        var employees: List<EmployeeDetails> = emptyList()
            set(value) {
                field = value
            }

        fun bind(employeeDetails: EmployeeDetails) {
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

    companion object DiffCallback : DiffUtil.ItemCallback<EmployeeDetails>(){
        override fun areItemsTheSame(oldItem: EmployeeDetails, newItem: EmployeeDetails): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: EmployeeDetails,
            newItem: EmployeeDetails
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