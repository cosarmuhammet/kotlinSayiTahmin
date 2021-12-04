package com.example.sayitahminkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonbasla =findViewById<Button>(R.id.buttonBasla)

        buttonbasla.setOnClickListener {

            startActivity(Intent(Intent(this@MainActivity,TahminActivity::class.java)))//Sayfa geçişi için
        }
    }
}