 package com.example.gasto_viagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gasto_viagem.databinding.ActivityMainBinding
import kotlin.Exception
import kotlin.NumberFormatException

 class MainActivity : AppCompatActivity(), View.OnClickListener{

     private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCalculate.setOnClickListener(this)

    }

     override fun onClick(view: View) {
         if(view.id == R.id.button_calculate){
          calculate()
         }
     }

     private  fun isValidation(): Boolean{
//         return binding.editDistence.text.toString() != ""
//                 && binding.editPrice.text.toString() != ""
//                 && binding.editAutonomy.text.toString() != ""
//                 && binding.editAutonomy.text.toString().toFloat() != 0F
        try {
             binding.editDistence.text.toString().toFloat()
             binding.editPrice.text.toString().toFloat()
             val autonomy = binding.editAutonomy.text.toString().toFloat()
             if(autonomy == 0f) throw IllegalArgumentException("Number cannot be to 0f")
             return true
         } catch (e: NumberFormatException){
             Toast.makeText(this, R.string.empty_text_field, Toast.LENGTH_SHORT).show()
         } catch (e: IllegalArgumentException){
             Toast.makeText(this, R.string.empty_text_autonomy_zero, Toast.LENGTH_SHORT).show()
         }

         return false
     }

     private fun calculate(){

//         if (isValidation()){
//
//             val distance = binding.editDistence.text.toString().toFloat()
//             val price = binding.editPrice.text.toString().toFloat()
//             val autonomy = binding.editAutonomy.text.toString().toFloat()
//
//             val totalValue = (distance * price) / autonomy
//
//             binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
//
//         } else{
//             Toast.makeText(this, R.string.empty_text_field, Toast.LENGTH_SHORT).show()
//         }

         if (isValidation()){
             val distance = binding.editDistence.text.toString().toFloat()
             val price = binding.editPrice.text.toString().toFloat()
             val autonomy = binding.editAutonomy.text.toString().toFloat()
             val totalValue = (distance * price) / autonomy
             binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
         }



         // Toast.makeText(this, totalValueStr, Toast.LENGTH_SHORT).show()
     }

 }