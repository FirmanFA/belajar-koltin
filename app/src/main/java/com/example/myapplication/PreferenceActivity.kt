package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityPreferenceBinding

class PreferenceActivity : AppCompatActivity() {
    lateinit var binding: ActivityPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = getSharedPreferences(SHARED_FILENAME, Context.MODE_PRIVATE)

        val namaShared = sharedPreference.getString("string_key","default")
        binding.textView3.text = namaShared



        binding.btnSave.setOnClickListener{
            val nama = binding.editTextTextPersonName.text.toString()
            val editor = sharedPreference.edit()
            editor.putString("string_key",nama)
            editor.apply()
            binding.textView3.text = nama
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
        }

        binding.btnClear.setOnClickListener {
            val editor = sharedPreference.edit()
            editor.clear()
            editor.apply()
            binding.textView3.text = "default"
            Toast.makeText(this, "cleared", Toast.LENGTH_SHORT).show()
        }



    }

    companion object{
        const val SHARED_FILENAME = "sharedfilename"
    }
}