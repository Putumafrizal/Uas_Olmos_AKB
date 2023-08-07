package com.example.uas_olmos_akb.data.repository

import com.example.uas_olmos_akb.data.remote.ApiService
import com.example.uas_olmos_akb.data.model.response.MotorcycleResponse
import retrofit2.Call
import retrofit2.Response

class MotorcycleRepository constructor(private val apiService: ApiService) {
    private val token = "j4Y+3+cSjAtln+2wkmN6IA==DNhUNCQiKobvPVMI"

    fun getMotorcycle() : Call<MotorcycleResponse> {
        return apiService.getMotorCycles(token, "kawasaki", "ninja 650")
    }
}