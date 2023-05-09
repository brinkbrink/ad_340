package com.example.clickcounterv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil
import com.example.clickcounterv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.num = 0
        binding.text = binding.num.toString()

        binding.incbutton.setOnClickListener {
            val ogNum = binding.num
            binding.num++
            binding.text = binding.num.toString()
            val toast = Toast.makeText(applicationContext, "$ogNum -> ${binding.num}", LENGTH_SHORT)
            toast.show()
        }

        binding.decbutton.setOnClickListener {
            val ogNum = binding.num
            binding.num--
            binding.text = binding.num.toString()
            val toast = Toast.makeText(applicationContext, "$ogNum -> ${binding.num}", LENGTH_SHORT)
            toast.show()
        }

        binding.resbutton.setOnClickListener {
            val ogNum = binding.num
            binding.num = 0
            binding.text = binding.num.toString()
            val toast = Toast.makeText(applicationContext, "$ogNum -> ${binding.num}", LENGTH_SHORT)
            toast.show()
        }
    }
}