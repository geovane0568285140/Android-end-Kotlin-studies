package com.example.usandoarquiteturamvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var textwelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()

    init {
        textwelcome.value = "Usando arquitetura MVVM :)"
    }

    fun teste(): LiveData<String>{
        return textwelcome
    }

    fun login(): LiveData<Boolean>{
        return login
    }

    fun doLogin(email: String, password: String){
        login.value = (email != "" && password != "")
    }



}