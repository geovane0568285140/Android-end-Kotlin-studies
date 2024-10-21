package com.devmasterteam.tasks.service.model

class ValidationModel(message: String = "") {

    private var status: Boolean = true
    private var _message: String = ""

    init {
        if (message != ""){
            _message = message
            status = false
        }
    }

    fun status(): Boolean {
        return status
    }

    fun message(): String{
        return _message
    }

}