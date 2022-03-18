package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPageDuaBinding

class PageDuaFragment : Fragment() {

    lateinit var binding: FragmentPageDuaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPageDuaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvHardCodeText.text = arguments?.getString("fragment1")

        binding.button.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val action = PageDuaFragmentDirections.actionPageDuaFragmentToPageTigaFragment(nama)
            it.findNavController().navigate(action)
        }


    }
}