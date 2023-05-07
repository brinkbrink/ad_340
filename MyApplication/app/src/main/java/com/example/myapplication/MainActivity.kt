package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val upButton: Button = findViewById(R.id.incbutton)
        val dwnButton: Button = findViewById(R.id.decbutton)
        val resButton: Button = findViewById(R.id.resbutton)

        val tv: TextView = findViewById(R.id.textView)
        val tvVal: String = tv.text.toString()
        var num: Int = Integer.parseInt(tvVal)

        upButton.setOnClickListener{
            val ogNum = num
            num++
            tv.text = num.toString()
            val text = "$ogNum -> $num "
            val toast = Toast.makeText(applicationContext, text, LENGTH_LONG)
            toast.show()
        }

        dwnButton.setOnClickListener{
            val ogNum = num
            num--
            tv.text = num.toString()
            val text = "$ogNum -> $num "
            val toast = Toast.makeText(applicationContext, text, LENGTH_LONG)
            toast.show()
        }

        resButton.setOnClickListener{
            val ogNum = num
            num = 0
            tv.text = num.toString()
            val text = "$ogNum -> $num "
            val toast = Toast.makeText(applicationContext, text, LENGTH_LONG)
            toast.show()
        }


    }
}