package com.example.testapirestrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance(): Retrofit{
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized){
                INSTANCE = Retrofit.Builder()
                    .client(http.build())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun <S> createService( clas : Class<S>): S{
            return getRetrofitInstance().create(clas)
        }

    }

}