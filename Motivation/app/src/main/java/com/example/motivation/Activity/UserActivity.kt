package com.example.motivation.Activity

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.Preferences.PreferencesConstants
import com.example.motivation.R
import com.example.motivation.Preferences.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSave.setOnClickListener(this)

        checkName()
    }

    private fun checkName() {
        val name = SecurityPreferences(this).getString(PreferencesConstants.key_Preferences.key_name)
        if (name != "") {
          startActivity(Intent(this, MainActivity::class.java))
          finish()
        }
    }


    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handlesave()
        }
    }

    private fun handlesave() {
        val name: String = binding.editWhatName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString(PreferencesConstants.key_Preferences.key_name, name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }

}