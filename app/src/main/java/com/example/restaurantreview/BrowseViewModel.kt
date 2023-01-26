package com.example.restaurantreview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BrowseViewModel : ViewModel() {

    private val _searchResults = MutableLiveData<List<GoogleSearching.Recipe>>().apply { value = null }
    val searchResults: LiveData<List<GoogleSearching.Recipe>>
        get() = _searchResults

    fun search(query: String, mainViewModel: MainActivityViewModel) {
        mainViewModel.search(query)
    }
}
