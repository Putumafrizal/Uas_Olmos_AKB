package com.example.uas_olmos_akb.data.remote

import com.example.uas_olmos_akb.data.model.response.MotorcycleResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/motorcycles")    //End Url
    fun getMotorCycles(@Header("X-Api-Key") apiKey: String,
                       @Query("make") make:String,
                       @Query("model") model:String,
    ): Call<MotorcycleResponse>

    companion object {

        var retrofitService: ApiService? = null
        val READ_TIMEOUT_SECONDS = 30L
        val CONNECT_TIMEOUT_SECONDS = 30L

        // Create a custom OkHttpClient with timeout settings
        val httpClient = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT_SECONDS, java.util.concurrent.TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, java.util.concurrent.TimeUnit.SECONDS)
            .build()
        //Create the Retrofit service instance using the retrofit.
        fun getInstance(): ApiService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.api-ninjas.com")
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiService::class.java)
            }
            return retrofitService!!
        }
    }
}