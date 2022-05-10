package com.example.apirecycler

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apirecycler.network.EmployeeApi
import com.example.apirecycler.network.EmployeeDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class EmployeeViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _properties = MutableLiveData<List<EmployeeDetails>>()
    val properties: LiveData<List<EmployeeDetails>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getEmployeeDetails()
    }

    private fun getEmployeeDetails() {
        coroutineScope.launch {
            val getValuesDeferred = EmployeeApi.RETROFIT_SERVICE.getValues()
            try {
                val listResult = getValuesDeferred.await()
                _status.value = "Success: Employee count = ${listResult.size}"
                if (listResult.isNotEmpty()) {
                    Log.d("API Response", "getEmployeeDetails: $listResult")
                    _properties.value = listResult
                }
            } catch (e:Exception) {
                _status.value = "Failure: " + e.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}