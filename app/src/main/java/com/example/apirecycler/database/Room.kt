package com.example.apirecycler.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.apirecycler.network.EmployeeDetails

@Dao
interface EmployeeDao {
    @Query(value = "select * from users")
    fun getEmployees(): LiveData<List<EmployeeDetails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg employees: ArrayList<EmployeeDetails>)
}

@Database(entities = [EmployeeDetails::class], version = 1)
abstract class EmployeesDatabase: RoomDatabase() {
    abstract val employeeDao: EmployeeDao
}

private lateinit var INSTANCE: EmployeesDatabase

fun getDataBase(context: Context): EmployeesDatabase {
    synchronized(EmployeesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext, EmployeesDatabase::class.java, "EmployeeDetails").build()
        }
    }
    return INSTANCE
}