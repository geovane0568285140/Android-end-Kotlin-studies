package com.devmasterteam.tasks.service.listener

import com.devmasterteam.tasks.service.model.PersonModel

interface APIListener<T> {

    fun onSuccess(model: PersonModel)

    fun onFailure(mensage: String)

}