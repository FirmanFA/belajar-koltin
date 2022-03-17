package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnNavDrawer.setOnClickListener {
            val intent = Intent(this, NavDrawerActivity::class.java)
            startActivity(intent)
        }

        binding.btnNavBar.setOnClickListener {
            val intent = Intent(this, BottomNavActivity::class.java)
            startActivity(intent)
        }

        binding.btnViewPager.setOnClickListener {
            val intent = Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {



//            val npm = binding.etNpm.text.toString().toInt()
//            val ipk = binding.etIpk.text.toString().toDouble()
//            val nama = binding.etNama.text.toString()
//            val intent = Intent(this, IntentActivity::class.java)

//            val bundle = Bundle()
//
//            bundle.apply {
//                putString("stringBundle",textString)
//                putInt("intBundle", textNumber)
//                putDouble("doubleBundle", textNumber.toDouble())
//            }
//
//            intent.apply {
//                putExtra("dataInt",textNumber)
//                putExtra("dataString",textString)
//                putExtra("dataDouble",textNumber.toDouble())
//                putExtras(bundle)
//            }

//            val mahasiswa = Mahasiswa(npm,nama,ipk)
//
//            intent.putExtra("dataMahasiswa",mahasiswa)
//
//            startActivity(intent)
        }





    }
}