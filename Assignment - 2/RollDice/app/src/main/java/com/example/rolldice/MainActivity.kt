package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var b: Button
    private lateinit var i: ImageView
    private lateinit var t: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        i = findViewById(R.id.imageView)
        t = findViewById(R.id.textView)
        b = findViewById(R.id.button)
        i.setImageResource(R.drawable._1)
        b.setOnClickListener {
            dice();
        }
    }
    fun dice() {
        var random = Random()
        var temp = random.nextInt(6)+1
        t.setText("You rolled a $temp")
        when(temp) {
            1 -> i.setImageResource(R.drawable._1)
            2 -> i.setImageResource(R.drawable._2)
            3 -> i.setImageResource(R.drawable._3)
            4 -> i.setImageResource(R.drawable._4)
            5 -> i.setImageResource(R.drawable._5)
            6 -> i.setImageResource(R.drawable._6)
        }
    }
}