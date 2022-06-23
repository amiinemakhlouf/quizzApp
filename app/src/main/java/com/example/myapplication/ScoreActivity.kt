package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val score=intent.getIntExtra("score",-1)
         binding.score.setText(score.toString()+"/3")

    }
}