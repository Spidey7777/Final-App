package com.example.apirecycler.repository

import android.net.Network
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.apirecycler.database.DatabaseEmployee
import com.example.apirecycler.database.EmployeesDatabase

import com.example.apirecycler.network.EmployeeApi
import com.example.apirecycler.network.EmployeeDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.apirecycler.network.asDatabaseModel
import java.util.ArrayList

class EmployeesRepository(private val database: EmployeesDatabase) {

    val empList: LiveData<List<DatabaseEmployee>> =database.employeeDao.getEmployees()

    suspend fun refreshList() {
        withContext(Dispatchers.IO) {
            val employeeList = EmployeeApi.RETROFIT_SERVICE.getValues().await()
            Log.d("log ", "refreshList() called" + employeeList)

            var inthalist : ArrayList<DatabaseEmployee> = arrayListOf()

            employeeList.forEach {

                var inthaItem = DatabaseEmployee(it.id, it.name, it.email, it.gender, it.status)
                inthalist.add(inthaItem)

            }

            database.employeeDao.insertAll(inthalist)
//            database.employeeDao.insertAll(*employeeList.asDatabaseModel())
        }
    }
}