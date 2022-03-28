package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPageSatuBinding

class PageSatuFragment : Fragment() {

    private lateinit var binding: FragmentPageSatuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPageSatuBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.LENGTH_LONG

        binding.btnToFragmentDua.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("fragment1", "Binarian")
            it.findNavController().navigate(R.id.action_pageSatuFragment_to_pageDuaFragment, bundle)
        }

    }

}