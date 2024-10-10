package com.example.usandoarquiteturamvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.usandoarquiteturamvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.buttonLogin.setOnClickListener(this)

        setObserve()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_login){
            val email: String = binding.editEmail.text.toString()
            val password: String = binding.editPassword.toString()

            viewModel.doLogin(email, password)
        }
    }

    private fun setObserve(){
        viewModel.teste().observe(this, Observer {
            binding.TextMVVM.text = it
        })
        viewModel.login().observe(this, Observer {
            if (it){
                Toast.makeText(applicationContext, "login correto, aplicação termina aqui :)", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(applicationContext, "Falha de login", Toast.LENGTH_SHORT).show()
            }
        })

    }



}