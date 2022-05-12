package com.example.apirecycler

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.apirecycler.database.getDatabase
import com.example.apirecycler.network.EmployeeApi
import com.example.apirecycler.network.EmployeeDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {
//    private val _status = MutableLiveData<String>()
//    val status: LiveData<String>
//        get() = _status
//
//    private val _employees = MutableLiveData<List<EmployeeDetails>>()
//    val employees: LiveData<List<EmployeeDetails>>
//        get() = _employees
//
//    private var viewModelJob = Job()
//    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
//
//    init {
//        getEmployeeDetails()
//    }
//
//    private fun getEmployeeDetails() {
//        coroutineScope.launch {
//            val getValuesDeferred = EmployeeApi.RETROFIT_SERVICE.getValues()
//            try {
//                val listResult = getValuesDeferred.await()
//                _status.value = "Success: Employee count = ${listResult.size}"
//                if (listResult.isNotEmpty()) {
//                    Log.d("API Response", "getEmployeeDetails: $listResult")
//                    _employees.value = listResult
//                }
//            } catch (e:Exception) {
//                _status.value = "Failure: " + e.message
//            }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }

    private val database = getDatabase(application)



    class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EmployeeViewModel(application) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}