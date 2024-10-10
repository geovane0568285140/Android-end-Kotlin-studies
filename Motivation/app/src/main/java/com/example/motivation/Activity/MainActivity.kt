package com.example.motivation.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.Preferences.PreferencesConstants
import com.example.motivation.R
import com.example.motivation.Preferences.SecurityPreferences
import com.example.motivation.data.Mock
import com.example.motivation.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId: Int = PreferencesConstants.categoryId.BaselineAll

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        supportActionBar?.hide()
        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } */

        getNameUser()
        handleFilter(binding.imageBaselineLl.id)


        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageBaselineLl.setOnClickListener(this)
        binding.imageBaselineEmojiEmotions.setOnClickListener(this)
        binding.imageBaselinaSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_new_phrase){
         shorPhrase(categoryId)
        }else if(view.id in listOf(R.id.image_baseline_ll, R.id.image_baselina_sunny, R.id.image_baseline_emoji_emotions)){
            handleFilter(view.id)
        }
    }


    private fun shorPhrase(categorySelect: Int){
         binding.textRisksTaken.text = Mock().getPhrase(categorySelect, Locale.getDefault().language)
    }

    private fun handleFilter(id: Int){

        binding.imageBaselinaSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageBaselineEmojiEmotions.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imageBaselineLl.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id) {
            R.id.image_baseline_ll -> {
                binding.imageBaselineLl.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = PreferencesConstants.categoryId.BaselineAll
            }
            R.id.image_baselina_sunny -> {
                binding.imageBaselinaSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = PreferencesConstants.categoryId.BaselinaSunny
            }
            R.id.image_baseline_emoji_emotions -> {
                binding.imageBaselineEmojiEmotions.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = PreferencesConstants.categoryId.BaselineEmojiEmotions
            }
        }

    }


    @SuppressLint("SetTextI18n")
    private fun getNameUser(){
        val name = SecurityPreferences(this).getString(PreferencesConstants.key_Preferences.key_name)
        binding.textUserName.text = "${getString(R.string.hello)}, $name!"
    }

}
