package com.example.myapplication.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CounterDatastoreManager(private val context: Context) {


    val getCounter: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[counter] ?: 0
        }

    fun getCounter(): Flow<Int>{
        return context.dataStore.data.map {
            it[counter] ?: 0
        }
    }

    //contoh 1 pakai val
    val getEmail: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[emailKey].toString()
        }

    //contoh 2 pakai fun
    fun getEmail(): Flow<String>{
        return context.dataStore.data.map {
            it[emailKey].toString()
        }
    }

    suspend fun setEmail(email: String){
        context.dataStore.edit {
            it[emailKey] = email
        }
    }

    suspend fun decrementCounter() {
        context.dataStore.edit { settings ->
            val currentCounterValue = settings[counter] ?: 0
            settings[counter] = currentCounterValue - 1
        }
    }

    suspend fun incrementCounter() {
        context.dataStore.edit { settings ->
            val currentCounterValue = settings[counter] ?: 0
            settings[counter] = currentCounterValue + 1
        }
    }

    companion object{
        private const val INT_KEY = "example_counter"
        private const val EMAIL = "emailkey"
        private const val JUMLAH = "jumlahkey"
        private const val TOKEN = "tokenkey"
        private const val DATA_STORE_KEY = "datastorekey"
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_KEY)
        val counter = intPreferencesKey(INT_KEY)
        val emailKey = stringPreferencesKey(EMAIL)
    }

}