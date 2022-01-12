package com.example.mvvpproject.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvpproject.data.api.MarsApi
import com.example.mvvpproject.data.model.Frog
import com.example.mvvpproject.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val _frogs = MutableLiveData<Resource<List<Frog>>>()

    fun getFrogs(): LiveData<Resource<List<Frog>>> {
        viewModelScope.launch {
            try {
                _frogs.postValue(Resource.success(MarsApi.retrofitService.getFrogs()))
            } catch (e: Exception) {
                _frogs.postValue(Resource.error("Something Went Wrong", null))
            }
        }
        return _frogs
    }

}