package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.data.User
import com.example.myapplication.database.MyDatabase
import com.example.myapplication.databinding.ActivityLoginBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private var myDatabase: MyDatabase? = null
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDatabase = MyDatabase.getInstance(this)
        val sharedPreference = getSharedPreferences(RoomActivity.SHARED_FILENAME, Context.MODE_PRIVATE)

//        GlobalScope.launch {
//            val user = User(null, "firman", "123")
//            myDatabase?.userDao()?.insertUser(user)
//        }

        binding.btnLogin.setOnClickListener {

            val username = binding.etNama.text.toString()

            GlobalScope.launch {
                val isLogin = myDatabase?.userDao()?.login(username)

                runOnUiThread {
                    if (isLogin == null){
                        Toast.makeText(this@LoginActivity, "Pastikan username dan password benar", Toast.LENGTH_SHORT).show()
                    }else{
                        val editor = sharedPreference.edit()
                        editor.putString("username",username)
                        editor.apply()
                        val intent = Intent(this@LoginActivity, RoomActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

            }




        }





    }
}