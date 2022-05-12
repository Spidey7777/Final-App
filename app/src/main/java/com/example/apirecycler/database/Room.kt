package com.example.apirecycler.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {
    @Query(value = "select * from databaseemployee")
    fun getEmployees(): LiveData<List<DatabaseEmployee>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg employees: DatabaseEmployee)
}

@Database(entities = [DatabaseEmployee::class], version = 1)
abstract class EmployeesDatabase: RoomDatabase() {
    abstract val employeeDao: EmployeeDao
}

private lateinit var INSTANCE: EmployeesDatabase

fun getDatabase(context: Context): EmployeesDatabase {
    synchronized(EmployeesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext, EmployeesDatabase::class.java, "employees").build()
        }
    }
    return INSTANCE
}