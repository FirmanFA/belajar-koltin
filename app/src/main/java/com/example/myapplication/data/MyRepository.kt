package com.example.myapplication.data

class MyRepository( private val apiHelper: ApiHelper) {

    suspend fun getDiscoverMovies() = apiHelper.getDiscoverMovies()

}