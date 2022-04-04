package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Student
import com.example.myapplication.databinding.RoomListLayoutBinding


class StudentAdapter(private val students: List<Student>,
                     private val delClick:(Student)->Unit,
                     private val editClick:(Student)-> Unit)
    : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(val binding: RoomListLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(currentStudent: Student,
                 delClick: (Student) -> Unit,
                 editClick: (Student) -> Unit){

            binding.apply {
                tvId.text = currentStudent.id.toString()
                tvNama.text = currentStudent.nama
                tvEmail.text = currentStudent.email

                btnEdit.setOnClickListener {
                    editClick(currentStudent)
                }

                btnDelete.setOnClickListener {
                    delClick(currentStudent)
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RoomListLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(students[position], delClick, editClick)
    }

    override fun getItemCount(): Int = students.size
}