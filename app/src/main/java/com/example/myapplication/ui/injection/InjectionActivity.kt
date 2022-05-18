package com.example.myapplication.ui.injection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.DiscoverAdapter
import com.example.myapplication.data.Status
import com.example.myapplication.di.NetworkModule
import com.example.myapplication.di.RepositoryModule
import com.example.myapplication.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class InjectionActivity : AppCompatActivity() {

    private val injectionViewModel: InjectionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_injection)

        val adapter = DiscoverAdapter {}
        findViewById<RecyclerView>(R.id.rv_injection).adapter = adapter

        injectionViewModel.discoverMovies.observe(this){
            when(it.status){
                Status.SUCCESS->{
                    adapter.submitList(it.data?.movieItems)
                }
                else -> {}
            }
        }
        injectionViewModel.getDiscoverMovies()

    }
}