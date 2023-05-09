package com.example.toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil
import com.example.toast.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.cheers = "Toast"

        val cheersArray = arrayOf("Cin! Cin!", "Sláinte!", "乾杯 (Kanpai!)", "Şerefe!", "건배 (Geonbae!)", "Salud!", "Prost!", "Santé!", "Saúde!", "Skål!", "Gesondheid!", "干杯 (Gānbēi!)", "Υγεία (Yamas!)")

        binding.button.setOnClickListener {
            var rand = Random.nextInt(0, 12)
            var cheers = cheersArray[rand]
            val toast = Toast.makeText(applicationContext, "$cheers", LENGTH_SHORT)
            toast.show()
        }
    }
}