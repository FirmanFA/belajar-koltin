package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPageTigaBinding

class PageTigaFragment : Fragment() {

    lateinit var binding: FragmentPageTigaBinding
    private val args: PageTigaFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPageTigaBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nama = args.nama
        binding.tvNama.text = nama

        binding.btnToNavKedua.setOnClickListener {
            it.findNavController().navigate(R.id.action_pageTigaFragment_to_kedua_navigation)
        }

    }

}