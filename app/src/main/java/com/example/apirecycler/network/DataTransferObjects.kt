package com.example.apirecycler.network

//import com.example.apirecycler.database.DatabaseEmployee
//import com.squareup.moshi.JsonClass
//
//@JsonClass(generateAdapter = true)
//data class NetworkEmployeeContainer(val employees: List<NetworkEmployee>)
//
//@JsonClass(generateAdapter = true)
//data class NetworkEmployee(
//    val id: Double,
//    val name: String,
//    val email: String,
//    val gender: String,
//    val status: String
//)
//
//fun NetworkEmployeeContainer.asDomainModel(): List<EmployeeDetails> {
//    return employees.map {
//        EmployeeDetails(
//            id = it.id,
//            name = it.name,
//            email = it.email,
//            gender = it.gender,
//            status = it.status
//        )
//    }
//}
//
//fun NetworkEmployeeContainer.asDatabaseModel(): Array<DatabaseEmployee> {
//    return employees.map {
//        DatabaseEmployee(
//            id = it.id,
//            name = it.name,
//            email = it.email,
//            gender = it.gender,
//            status = it.status
//        )
//    }.toTypedArray()
//}