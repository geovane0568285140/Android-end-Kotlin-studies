package com.devmasterteam.tasks.service.repository

import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.model.PersonModel
import com.devmasterteam.tasks.service.repository.remote.PersonService
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {

    val remote = RetrofitClient.getService(PersonService::class.java)

    fun personLogin(email: String, password: String, listener: APIListener<PersonModel>) {

        val call = remote.login(email, password)

        call.enqueue(object : Callback<PersonModel> {
            override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
                val s = ""
                if(response.code() == 200){
                    response.body()!!.let { listener.onSuccess(it) }
                } else {
                    listener.onFailure(response.message().toString())
                }

            }

            override fun onFailure(call: Call<PersonModel>, t: Throwable) {
                val c = ""
                listener.onFailure(R.string.ERROR_UNEXPECTED.toString())
            }
        })

    }


}