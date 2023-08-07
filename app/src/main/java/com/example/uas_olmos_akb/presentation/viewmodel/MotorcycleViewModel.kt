package com.example.uas_olmos_akb.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uas_olmos_akb.data.model.response.MotorcycleResponse
import com.example.uas_olmos_akb.data.model.response.MotorcycleResponseItem
import com.example.uas_olmos_akb.data.repository.MotorcycleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MotorcycleViewModel(private val repository: MotorcycleRepository) : ViewModel() {

    val motorcycle = MutableLiveData<List<MotorcycleResponseItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getMotorcycle() {
        Log.d("test", "masuk viewmodel")
        val response = repository.getMotorcycle()
        Log.d("test", "$response")
        response.enqueue(object : Callback<MotorcycleResponse> {
            override fun onResponse(call: Call<MotorcycleResponse>, response: Response<MotorcycleResponse>) {
               Log.d("test", "${response.body()}")
                motorcycle.postValue(response.body())
            }

            override fun onFailure(call: Call<MotorcycleResponse>, t: Throwable) {
                Log.d("test", "error bang $t")
                errorMessage.postValue(t.message)
            }
        })
    }
}