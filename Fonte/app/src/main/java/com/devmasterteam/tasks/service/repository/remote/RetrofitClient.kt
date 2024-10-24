package com.devmasterteam.tasks.service.repository.remote

import com.devmasterteam.tasks.service.constants.TaskConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private var tokenKey: String = ""
        private var personKey: String = ""

        private fun getRetrofiClient(): Retrofit {

            val http = OkHttpClient.Builder()

            http.addInterceptor(object : Interceptor{
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain.request()
                        .newBuilder()
                        .header(TaskConstants.HEADER.TOKEN_KEY, tokenKey)
                        .header(TaskConstants.HEADER.PERSON_KEY, personKey)
                        .build()
                    return chain.proceed(request)
                }
            })

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


        fun <T> getService(serviceClass:  Class<T>): T{
            return getRetrofiClient().create(serviceClass)
        }

        fun addHeards(tokenKeyValue: String, personKeyValeu: String){
            tokenKey = tokenKeyValue
            personKey = personKeyValeu
        }


    }
}