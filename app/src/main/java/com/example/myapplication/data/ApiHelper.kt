package com.example.myapplication.data

class ApiHelper(private val apiService: ApiService) {

    suspend fun getDiscoverMovies() = apiService.getDiscoverMovie()

}