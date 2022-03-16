package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val tvViewIntent = findViewById<TextView>(R.id.tvLihatIntent)

//        val numberFromActivity = intent.getIntExtra("dataInt",0)
//        val stringFromActivity = intent.getStringExtra("dataString")
//        val doubleFromActivity = intent.getDoubleExtra("dataDouble",0.0)
//
//        val getBundle = intent.extras

//        val mahasiswaDariIntent = intent.getSerializableExtra("dataMahasiswa") as Mahasiswa
        val parcelableMahasiswa = intent.getParcelableExtra<Mahasiswa>("dataMahasiswa")

//        val stringBundle = getBundle?.getString("stringBundle")
//        val intBundle = getBundle?.getInt("intBundle")
//        val doubleBundle = getBundle?.getDouble("doubleBundle")

        val npm = parcelableMahasiswa?.npm
        val ipk = parcelableMahasiswa?.ipk
        val nama = parcelableMahasiswa?.nama

        tvViewIntent.text  = "$npm \n $nama \n $ipk"


    }
}