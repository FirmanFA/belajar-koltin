package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentPageEmpatBinding


class PageEmpatFragment : Fragment() {


    lateinit var binding: FragmentPageEmpatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPageEmpatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNavPertama.setOnClickListener {
            it.findNavController().navigate(R.id.action_pageEmpatFragment2_to_bindingActivity3)
        }
    }

}