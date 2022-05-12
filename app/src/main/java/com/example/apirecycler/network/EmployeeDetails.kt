package com.example.apirecycler.network

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class EmployeeDetails(
    @PrimaryKey
    val id: Double,
    val name: String,
    val email: String,
    val gender: String,
    val status: String
)