package com.devmasterteam.tasks.service.repository.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private lateinit var INSTANCE: Retrofit

        private fun getRetrofiClient(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                synchronized(Retrofit::class.java) {
                    INSTANCE = Retrofit.Builder()
                        .client(http.build())
                        .baseUrl("http://devmasterteam.com/CursoAndroidAPI/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return INSTANCE
        }
    }
}