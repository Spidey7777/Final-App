package com.example.apirecycler.repository

import androidx.lifecycle.LiveData
import com.example.apirecycler.database.DatabaseEmployee
import com.example.apirecycler.database.EmployeesDatabase

import com.example.apirecycler.network.EmployeeApi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import java.util.ArrayList

class EmployeesRepository(private val database: EmployeesDatabase) {

    val empList: LiveData<List<DatabaseEmployee>> =database.employeeDao.getEmployees()

    suspend fun refreshList() {
        withContext(Dispatchers.IO) {
            val employeeList = EmployeeApi.RETROFIT_SERVICE.getValues().await()
//            Log.d("log ", "refreshList() called" + employeeList)

            val inthalist : ArrayList<DatabaseEmployee> = arrayListOf()

            employeeList.forEach {

                val inthaItem = DatabaseEmployee(it.id, it.name, it.email, it.gender, it.status)
                inthalist.add(inthaItem)

            }

            database.employeeDao.insertAll(inthalist)
        }
    }
}