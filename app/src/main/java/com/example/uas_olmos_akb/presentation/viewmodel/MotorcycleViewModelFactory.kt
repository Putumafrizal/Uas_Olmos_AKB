package com.example.uas_olmos_akb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uas_olmos_akb.data.model.response.MotorcycleResponse
import com.example.uas_olmos_akb.data.model.response.MotorcycleResponseItem
import com.example.uas_olmos_akb.data.repository.MotorcycleRepository
import androidx.lifecycle.ViewModelProvider

class MotorcycleViewModelFactory constructor(private val repository: MotorcycleRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MotorcycleViewModel::class.java)) {
            MotorcycleViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}