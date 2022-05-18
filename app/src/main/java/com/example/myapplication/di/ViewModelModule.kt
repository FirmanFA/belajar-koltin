package com.example.myapplication.di

import com.example.myapplication.ui.injection.InjectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ViewModelModule = module {
    viewModelOf(::InjectionViewModel)
}
