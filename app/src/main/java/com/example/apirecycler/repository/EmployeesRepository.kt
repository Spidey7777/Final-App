package com.example.apirecycler.repository

import com.example.apirecycler.database.EmployeesDatabase
import com.example.apirecycler.network.EmployeeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.apirecycler.network.asDatabaseModel

class EmployeesRepository(private val database: EmployeesDatabase) {

    val empList =

    suspend fun refreshList() {
        withContext(Dispatchers.IO) {
            val employeeList = EmployeeApi.RETROFIT_SERVICE.getValues().await()
//            database.employeeDao.insertAll(*employeeList.asDatabaseModel())
            database.employeeDao.insertAll(*employeeList.asDatabaseModel())
        }
    }
}