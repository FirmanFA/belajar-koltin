package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val builder = Glide.with(this).load(R.drawable.avatar).circleCrop()

        builder.into(binding.imageView)
        builder.into(binding.imageView5)
        builder.into(binding.imageView6)

        //set register text with multiple color
        val tvRegister = "<b>307 Mutual connections:</b> " +
                "Dr. Pratama Persadha, Norman Santoso, Firmansyah"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.textView9.text = Html.fromHtml(tvRegister, Html.FROM_HTML_MODE_LEGACY)
        }else{
            binding.textView9.text = Html.fromHtml(tvRegister)
        }


    }
}