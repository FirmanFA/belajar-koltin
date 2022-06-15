package com.example.myapplication.data

import com.example.myapplication.data.model.MovieResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class MyRepositoryTest {

    //collaborator
    private lateinit var apiService: ApiService
    private lateinit var apiHelper: ApiHelper

    //system uder test
    private lateinit var myRepository: MyRepository

    @Before
    fun setUp() {

        apiService = mockk()
        apiHelper = ApiHelper(apiService)
        myRepository = MyRepository(apiHelper)

    }

    @Test
    fun getDiscoverMovies() = runBlocking {
        val responseMovies = mockk<MovieResponse>()

        every {
            runBlocking {
                apiService.getDiscoverMovie()
            }
        } returns responseMovies

        myRepository.getDiscoverMovies()

        verify {
            runBlocking { apiService.getDiscoverMovie() }
        }

    }
}