package com.example.restaurantreview

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import com.example.restaurantreview.GoogleSearching
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MainActivityViewModel : ViewModel() {
    private var _searchResults: ArrayList<GoogleSearching.Recipe>? = null
    var searchResults: ArrayList<GoogleSearching.Recipe>? = null
        get() = _searchResults

    fun search(query: String): ArrayList<GoogleSearching.Recipe>? {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Log.i("VMmainActivity","Search Launched")
                try {
                    val results = GoogleSearching(query).searchResults
                    _searchResults = results
                    Log.i("VMmainActivity","$searchResults try")
                } catch (e: Exception) {
                    _searchResults = null
                    Log.i("VMmainActivity", "$searchResults except Error: ${e.message}")
                }
            }
        }
        return searchResults
    }


}



