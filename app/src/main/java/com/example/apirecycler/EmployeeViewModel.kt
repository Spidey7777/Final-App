package com.example.apirecycler

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.apirecycler.database.getDataBase
import com.example.apirecycler.repository.EmployeesRepository
import kotlinx.coroutines.launch

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
//                val listResult = (getValuesDeferred.await()).asDomainModel()
//                _status.value = "Success: Employee count = ${listResult.size}"
//                if (listResult.isNotEmpty()) {
//                    Log.d("API Response", "getEmployeeDetails: $listResult")
//                    _employees.value = listResult
//                }
//            } catch (e:Exception) {
//                _status.value = "Failure: " + e.messa private val database = getDatabase(application)
//            }
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }

    private val database = getDataBase(application)
    private val repository = EmployeesRepository(database)

    init {
        viewModelScope.launch {
            repository.refreshList()
        }
    }

    val emplist = repository.employees

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EmployeeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}