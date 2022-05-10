package com.example.myapplication.datastore

import android.provider.ContactsContract
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class CounterViewModel(private val pref: CounterDatastoreManager): ViewModel() {

    fun increment(){
        viewModelScope.launch {
            pref.incrementCounter()
        }
    }

    fun decrement(){
        viewModelScope.launch {
            pref.decrementCounter()
        }
    }

    fun setEmail(email: String){
        viewModelScope.launch {
            pref.setEmail(email)
        }
    }

    val getDataStore = pref.getCounter.asLiveData()
    val getEmail = pref.getEmail.asLiveData()

}

class CounterViewModelFactory(private val pref: CounterDatastoreManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CounterViewModel(pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}