package com.example.uas_olmos_akb.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_olmos_akb.data.model.response.MotorcycleResponseItem
import com.example.uas_olmos_akb.repository.MotorcycleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MotorcycleViewModel(
    private val motorcycleRepository: MotorcycleRepository
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _listDetail = MutableLiveData<List<MotorcycleResponseItem?>>()
    val listDetail: LiveData<List<MotorcycleResponseItem?>> = _listDetail

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun getMotorcycleDetail() {
        _isLoading.postValue(true)
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val response = motorcycleRepository.getMotorcycle()
                response.body()
            }.onSuccess { motorDetail ->
                withContext(Dispatchers.Main) {
                    _listDetail.value = motorDetail
                }
            }.onFailure { throwable ->
                withContext(Dispatchers.Main) {
                    _errorMessage.value = throwable.message
                }
            }.also {
                withContext(Dispatchers.Main) {
                    _isLoading.postValue(false)
                }
            }
        }
    }
}