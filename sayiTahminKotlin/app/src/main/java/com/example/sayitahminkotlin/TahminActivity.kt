package com.example.sayitahminkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

    class TahminActivity : AppCompatActivity() {
    private var rastgeleSayi=0
    private  var sayac =5 // KALANHAK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        rastgeleSayi= Random.nextInt(51) // 0 ile 100 arasında random sayı oluşturduk
        Log.e("Random sayı",rastgeleSayi.toString()) //Log .e konsola sayı bastırdık
        //to.String() int veriyi string veriye döndürdük

        var buttonTahmin =findViewById<Button>(R.id.buttonTahmin)
        var editTextGirdi= findViewById (R.id.editTextGirdi) as EditText

        buttonTahmin.setOnClickListener {
            //startActivity(Intent(this@Tahminactivity,SonucActivity::class.java))  //Sayfa geçişi için
            //finish()

            sayac=sayac-1

            val tahmin=editTextGirdi.text.toString().toInt()
            /*
               edit text den alınan sayı string olduğu için onu
               int yaptık
            */
            if(tahmin==rastgeleSayi){
                val intent =Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",true)
                /* sonuç ekranın arayüzünü değiştirmek için
                veri gönderimi yaptık .true değer olduğu için kazandınız yazacak
                */


                finish()
                startActivity(intent)

                return@setOnClickListener

            }
            if (tahmin > rastgeleSayi){
                var textViewYardim=findViewById(R.id.textViewYardim) as TextView
                textViewYardim.text="Azalt"

                var textViewKalanHak=findViewById(R.id.textViewKalanHak) as TextView
                textViewKalanHak.text="Kalan Hak :$sayac "

            }
            if (tahmin<rastgeleSayi){
                var textViewYardim=findViewById(R.id.textViewYardim) as TextView
                textViewYardim.text="Arttır"

                var textViewKalanHak=findViewById(R.id.textViewKalanHak) as TextView
                textViewKalanHak.text="Kalan Hak :$sayac "

            }
            if(sayac==0){
                val intent =Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc",false)
                /* sonuç ekranın arayüzünü değiştirmek için
                veri gönderimi yaptık .false değer olduğu için kazandınız yazacak


                */
                intent.putExtra("rastgeleSayi", rastgeleSayi)
                finish()
                startActivity(intent)
            }
            editTextGirdi.setText("") // tekrar sayı girilmesi için edit text temizler
        }
    }
}