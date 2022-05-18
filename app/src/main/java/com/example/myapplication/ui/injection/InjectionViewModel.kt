package com.example.myapplication.ui.injection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.MyRepository
import com.example.myapplication.data.Resource
import com.example.myapplication.data.model.MovieResponse
import kotlinx.coroutines.launch

class InjectionViewModel(private val repository: MyRepository): ViewModel() {

    private val _discoverMovies = MutableLiveData<Resource<MovieResponse>>()
    val discoverMovies: LiveData<Resource<MovieResponse>> get() = _discoverMovies

     fun getDiscoverMovies(){
        viewModelScope.launch {
            _discoverMovies.postValue(Resource.loading())
            try {
                val dataDiscover = repository.getDiscoverMovies()
                val successResource = Resource.success(dataDiscover)
                _discoverMovies.postValue(successResource)
            }catch (exp: Exception){
                _discoverMovies.postValue(Resource.error(exp.localizedMessage ?: "Error occured"))
            }
        }
    }

}