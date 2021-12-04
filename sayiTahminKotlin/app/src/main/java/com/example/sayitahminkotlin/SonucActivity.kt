package com.example.sayitahminkotlin


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_sonuc.*

class SonucActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val sonuc =intent.getBooleanExtra("sonuc",false)//gelen veriyi aldık
        val rastgeleSayi = intent.getIntExtra("rastgeleSayi", 0)//++
        Log.e("rastgeleSayi", rastgeleSayi.toString())//++

        var textViewSonuc=findViewById(R.id.textViewSonuc) as TextView
        val imageViewSonuc = findViewById<ImageView>(R.id.imageViewSonuc)

        if (sonuc){
            textViewSonuc.text="-KAZANDINIZ-"
            imageViewSonuc.setImageResource(R.drawable.tik_isareti)

        }else{
            textViewSonuc.text="-KAYBETTİNİZ-"
            imageViewSonuc.setImageResource(R.drawable.carp_resim)

            textViewTutulanSayi.text = "Tutulan sayı : " + rastgeleSayi///++++

            val TutulanSayi=intent.getIntExtra("Tutulan sayı",0)
            var textViewTutulanSayi =findViewById<TextView>(R.id.textViewTutulanSayi)

        }

        var buttonTekrar =findViewById<Button>(R.id.buttonTekrar)

        buttonTekrar.setOnClickListener{
            val intent = Intent(this@SonucActivity,MainActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}