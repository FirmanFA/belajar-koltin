package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.adapter.StudentAdapter
import com.example.myapplication.data.User
import com.example.myapplication.database.MyDatabase
import com.example.myapplication.databinding.ActivityRoomBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity() {
    private var myDatabase: MyDatabase? = null
    private lateinit var binding: ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDatabase = MyDatabase.getInstance(this)
        val sharedPreference = getSharedPreferences(SHARED_FILENAME, Context.MODE_PRIVATE)

        val userShared = sharedPreference.getString("username","")

        if (userShared == ""){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            GlobalScope.launch {
                val myDb = myDatabase?.userDao()
                val loginUser = myDb?.login(userShared.toString())
                runOnUiThread {
                    Toast
                        .makeText(this@RoomActivity,
                            "Login as ${loginUser?.username}",
                            Toast.LENGTH_SHORT).show()
                }
            }
            fetchStudent()
        }






    }

    private fun fetchStudent(){
        fetchData()
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchData(){
        GlobalScope.launch {
            val myDb = myDatabase?.studentDao()
            val listStudent = myDb?.getAllStudent()

            runOnUiThread {
                listStudent?.let {
                    val adapter = StudentAdapter(it, {deleteStudent ->
                        GlobalScope.async {
                            val result = myDb.deleteStudent(deleteStudent)

                            runOnUiThread {
                                if (result==0){
                                    Toast
                                        .makeText(this@RoomActivity,
                                            "gagal delete",
                                            Toast.LENGTH_SHORT)
                                        .show()
                                }else{
                                    Toast
                                        .makeText(this@RoomActivity,
                                            "berhasil delete",
                                            Toast.LENGTH_SHORT)
                                        .show()
                                    fetchData()
                                }
                            }

                        }

                    }, {updateStudent ->
                        val intent = Intent(this@RoomActivity, FormActivity::class.java)
                        intent.putExtra("student", updateStudent)
                        startActivity(intent)
                    })
                    binding.rvStudent.adapter = adapter
                }
            }

        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    override fun onDestroy() {
        super.onDestroy()
        MyDatabase.destroyInstance()
    }

    companion object{
        const val SHARED_FILENAME = "filename"
    }

}