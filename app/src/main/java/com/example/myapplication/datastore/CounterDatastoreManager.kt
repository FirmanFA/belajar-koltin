package com.example.myapplication.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CounterDatastoreManager(private val context: Context) {


    val getCounter: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[counter] ?: 0
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
        private const val DATA_KEY = "example_counter"
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_KEY)
        val counter = intPreferencesKey(DATA_KEY)
    }

}