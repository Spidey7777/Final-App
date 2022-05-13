package com.example.apirecycler.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apirecycler.network.EmployeeDetails

@Entity(tableName = "DatabaseEmployee")
data class DatabaseEmployee (
    @PrimaryKey
    val id: Double,
    val name: String,
    val email: String,
    val gender: String,
    val status: String
)

//Stringfun List<DatabaseEmployee>.asDomainModel(): List<EmployeeDetails> {
//    return map {
//        EmployeeDetails(
//            id = it.id,
//            name = it.name,
//            email = it.email,
//            gender = it.gender,
//            status = it.status
//        )
//    }
//}