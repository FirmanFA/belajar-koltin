package com.example.myapplication.di

import com.example.myapplication.data.MyRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val RepositoryModule = module {
    singleOf(::MyRepository)
}
