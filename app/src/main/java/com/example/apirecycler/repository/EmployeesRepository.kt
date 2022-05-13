package com.example.apirecycler.repository

import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.apirecycler.database.EmployeesDatabase
import com.example.apirecycler.database.asDomainModel
import com.example.apirecycler.network.EmployeeApi
import com.example.apirecycler.network.EmployeeDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.apirecycler.network.asDatabaseModel

class EmployeesRepository(private val database: EmployeesDatabase) {

    val empList: LiveData<List<EmployeeDetails>> = Transformations.map(database.employeeDao.getEmployees()) {
        it.asDomainModel()
    }

    suspend fun refreshList() {
        withContext(Dispatchers.IO) {
            val employeeList = EmployeeApi.RETROFIT_SERVICE.getValues().await()
//            database.employeeDao.insertAll(*employeeList.asDatabaseModel())
            database.employeeDao.insertAll(*employeeList.asDatabaseModel())
        }
    }
}