package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myapplication.databinding.ActivityDatastoreBinding
import com.example.myapplication.datastore.CounterDatastoreManager
import com.example.myapplication.datastore.CounterViewModel
import com.example.myapplication.datastore.CounterViewModelFactory

class DatastoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatastoreBinding

    private val counterViewModel: CounterViewModel by viewModels {
        CounterViewModelFactory(CounterDatastoreManager(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatastoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterViewModel.getDataStore.observe(this){
            binding.tvDatasaved.text = it.toString()
        }

        binding.btnMin.setOnClickListener {
            counterViewModel.decrement()
        }

        binding.btnPlus.setOnClickListener {
            counterViewModel.increment()
        }

    }


}