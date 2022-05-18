package com.example.myapplication.data

import com.example.myapplication.data.model.DetailMovieResponse
import com.example.myapplication.data.model.MovieResponse
import com.example.myapplication.data.model.ReviewResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("discover/movie")
    suspend fun getDiscoverMovie(): MovieResponse



}