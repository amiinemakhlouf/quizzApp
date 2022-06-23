package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.MediaParser
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var questionNumber=1
        var listOfQuizz = mutableListOf<Drawable>()
        var listOfQuizzAnswers:MutableList<String>
        var listOfQuizzLogoAnswers:List<Drawable>
        var type = intent.getStringExtra("quizz")
        var score=0
        if (type == "Logo") {
            listOfQuizzAnswers= mutableListOf<String>("instagram","facebook","ferrari")
            listOfQuizz.add(resources.getDrawable(R.drawable.instagram))
            listOfQuizz.add(resources.getDrawable(R.drawable.facebook))
            listOfQuizz.add(resources.getDrawable(R.drawable.ferrari))
        }
        else if(type=="Drapeau"){

            listOfQuizzAnswers= mutableListOf<String>("tunisie","maroc","algerie")
            listOfQuizz.add(resources.getDrawable(R.drawable.tunisie))
            listOfQuizz.add(resources.getDrawable(R.drawable.maroc))
            listOfQuizz.add(resources.getDrawable(R.drawable.algerie))


        }
        else {
            listOfQuizzAnswers= mutableListOf<String>("salah","mbappe","mahrez")
            listOfQuizz.add(resources.getDrawable(R.drawable.salah))
            listOfQuizz.add(resources.getDrawable(R.drawable.mbappe))
            listOfQuizz.add(resources.getDrawable(R.drawable.mahrez))


        }


        var currentItem = 0
        binding.logo.setImageDrawable(listOfQuizz[currentItem])

        binding.confirmerButton.setOnClickListener {

            if (
                binding.resultat.editText!!.text.toString()
                    .toLowerCase() == listOfQuizzAnswers[currentItem]

            ) {
                score++
                binding.view3.setBackgroundColor(Color.parseColor("#00FF00"))
            }


            else {
                binding.view3.setBackgroundColor(Color.parseColor("#ff0000"))

            }
            currentItem++
            Handler(Looper.getMainLooper()).postDelayed({
                /* Create an Intent that will start the Menu-Activity. */
               if(currentItem<listOfQuizz.size)
               {
                   binding.logo.setImageDrawable(listOfQuizz[currentItem])
                   binding.view3.setBackgroundColor(Color.parseColor("#e0dfbc"))
                   binding.resultat.editText!!.text.clear()
                   questionNumber ++
                   binding.questionNumber.setText(questionNumber.toString())

               }
                else{

                    var intent=Intent(this,ScoreActivity::class.java)
                   intent.putExtra("score",score)
                   startActivity(intent)

               }
            }, 300)


        }
        binding.passerButton.setOnClickListener {

            currentItem++
            if (currentItem < listOfQuizz.size) {
                binding.logo.setImageDrawable(listOfQuizz[currentItem])
                binding.resultat.editText!!.text.clear()
                questionNumber++
                binding.questionNumber.setText(questionNumber.toString())


            }
            else{
                val intent=Intent(this,ScoreActivity::class.java)
                startActivity(intent)
            }

        }

    }
}