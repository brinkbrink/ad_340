package com.example.moodyshibainu

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iv: ImageView = findViewById(R.id.imageView2)
        val food: Button = findViewById(R.id.button)
        val touch: Button = findViewById(R.id.button2)
//        val angry: Image =

        food.setOnClickListener{
            iv.setImageResource(R.drawable.calm)
            val text = "Thank you! I love you!"
            val toast = Toast.makeText(applicationContext, text, LENGTH_SHORT)
            toast.show()
        }

        touch.setOnClickListener{
            iv.setImageResource(R.drawable.angry)
            val text = "No food?? That angers me!"
            val toast = Toast.makeText(applicationContext, text, LENGTH_SHORT)
            toast.show()
        }

    }
}