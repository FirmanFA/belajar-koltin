package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.NetworkModule
import com.example.myapplication.di.RepositoryModule
import com.example.myapplication.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(NetworkModule, RepositoryModule, ViewModelModule)
        }
    }
}