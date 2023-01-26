package com.example.restaurantreview

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantreview.databinding.FragmentBrowseBinding

private lateinit var adapter: MyAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var recipesArrayList: ArrayList<Recipes>

lateinit var imageId : Array<Int>
lateinit var recipe: Array<String>
lateinit var title: Array<String>

//private lateinit var btnRecipe : Button
private lateinit var binding: FragmentBrowseBinding

class Browse : Fragment(R.layout.fragment_browse) {

    companion object {
        fun newInstance() = Browse()
    }

    private var searchResults = ArrayList<GoogleSearching.Recipe>()

    private lateinit var viewModel: BrowseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrowseBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("Browse", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvBrowse)
        recyclerView.layoutManager = layoutManager
        viewModel = ViewModelProvider(this).get(BrowseViewModel::class.java)
        viewModel.searchResults.observe(viewLifecycleOwner, Observer { searchResults ->
            if (searchResults != null) {
                val searchResults = arguments?.getSerializable("searchResults") as ArrayList<GoogleSearching.Recipe>
                recyclerView.adapter = MyAdapter(searchResults)
                adapter = MyAdapter(searchResults)
                recyclerView.adapter = adapter
            }
        })
    }
}


