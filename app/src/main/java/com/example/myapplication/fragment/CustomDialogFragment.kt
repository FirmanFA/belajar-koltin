package com.example.myapplication.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.myapplication.databinding.FragmentCustomDialogBinding
import java.lang.IllegalStateException

class CustomDialogFragment(private val nama: String): DialogFragment() {

    lateinit var binding: FragmentCustomDialogBinding


    //create dialog using onCreateDialog method
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = FragmentCustomDialogBinding.inflate(layoutInflater)
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setView(binding.root)
            binding.tvNama.text = "Nama anda: $nama"
            binding.btnDialog.setOnClickListener {
                Toast.makeText(context, "ini diklik dari fragment", Toast.LENGTH_SHORT).show()
                dialog?.dismiss()
            }
            builder.create()
        }?:throw IllegalStateException("Activity cannot be null")
    }

    //create dialog using default fragment method

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentCustomDialogBinding.inflate(inflater,container, false)
//        return binding.root
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        dialog?.window
//            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.tvNama.text = "Nama anda: $nama"
//        binding.btnDialog.setOnClickListener {
//            Toast.makeText(context, "ini diklik dari fragment", Toast.LENGTH_SHORT).show()
//            dialog?.dismiss()
//        }
//
//    }

}