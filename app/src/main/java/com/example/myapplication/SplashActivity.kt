package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySplashBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val singleItems = arrayOf("Sport", "Drapeau", "Logo")
        var checkedItem = 1
        var alertDialog= MaterialAlertDialogBuilder(this)
            .setTitle("choisir le quizz")

            .setPositiveButton("ok") { dialog, which ->
                Toast.makeText(this,singleItems[checkedItem],Toast.LENGTH_SHORT).show()
                var intent=Intent(this,MainActivity::class.java)
                intent.putExtra("quizz",singleItems[checkedItem])
                startActivity(intent)
            }
            // Single-choice items (initialized with checked item)
            .setSingleChoiceItems(singleItems, checkedItem) { dialog, which ->
                checkedItem=which

            }

        binding.quizzButton.setOnClickListener {
           // startActivity(intent)
            alertDialog.show()
        }





    }
}