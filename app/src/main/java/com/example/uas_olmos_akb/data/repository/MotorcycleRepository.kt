package com.example.uas_olmos_akb.data.repository

import com.example.uas_olmos_akb.data.remote.ApiService
import com.example.uas_olmos_akb.data.model.response.MotorcycleResponse

class MotorcycleRepository(
    private val apiService: ApiService
) {

    private val token = "j4Y+3+cSjAtln+2wkmN6IA==DNhUNCQiKobvPVMI"

    suspend fun getMotorcycle() : Response<MotorcycleResponse> {
        return apiService.getMotorcycle(token, "Kawasaki", "Ninja")
    }
}