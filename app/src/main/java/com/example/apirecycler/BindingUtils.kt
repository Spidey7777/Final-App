package com.example.apirecycler

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.apirecycler.network.EmployeeDetails

@BindingAdapter("genderImage")
fun ImageView.setEmployeeImage(item: EmployeeDetails?) {
    item?.let {
        setImageResource(when (item.gender) {
            "male" -> R.drawable.man
            else -> R.drawable.woman
        })
    }
}