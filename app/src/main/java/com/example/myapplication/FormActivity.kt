package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.data.Student
import com.example.myapplication.database.MyDatabase
import com.example.myapplication.databinding.ActivityFormBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class FormActivity : AppCompatActivity() {
    private var myDatabase: MyDatabase? = null
    private lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDatabase = MyDatabase.getInstance(this)

        val student: Student? = intent.getParcelableExtra("student")

        if (student ==null){
            //do add
            addData()
        }else{
            //do edit
            editData(student)
        }

    }

    private fun editData(student: Student){
        binding.apply {
            etNama.setText(student.nama)
            etEmail.setText(student.email)

            btnSave.setOnClickListener {
                val newStudent = Student(
                    student.id,
                    etNama.text.toString(),
                    etEmail.text.toString()
                )
                GlobalScope.async {
                    val result = myDatabase?.studentDao()?.updateStudent(newStudent)

                    runOnUiThread {
                        if (result == 0){
                            Toast.makeText(this@FormActivity,
                                "gagal update", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@FormActivity,
                                "sukses update", Toast.LENGTH_SHORT).show()
                        }
                        finish()


                    }

                }
            }

        }
    }

    private fun addData(){
        binding.apply {
            btnSave.setOnClickListener {
                val student = Student(null, etNama.text.toString(), etEmail.text.toString())
                GlobalScope.async {
                    val result = myDatabase?.studentDao()?.insertStudent(student)
                    runOnUiThread {
                        if (result == (0).toLong()){
                            Toast.makeText(this@FormActivity,
                                "gagal insert", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@FormActivity,
                                "sukses insert", Toast.LENGTH_SHORT).show()
                        }
                        finish()
                    }
                }
            }
        }
    }
}