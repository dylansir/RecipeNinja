package com.example.restaurantreview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantreview.databinding.ActivityMainBinding
import com.example.restaurantreview.databinding.FragmentBrowseBinding

private lateinit var adapter: MyAdapter
private lateinit var recyclerView: RecyclerView
private lateinit var recipesArrayList: ArrayList<Recipes>

lateinit var imageId : Array<Int>
lateinit var recipe: Array<String>
lateinit var title: Array<String>

//private lateinit var btnRecipe : Button
private lateinit var binding: FragmentBrowseBinding

class Browse : Fragment() {

    companion object {
        fun newInstance() = Browse()
    }

    private var searchResults = ArrayList<GoogleSearch.Recipe>()

    private lateinit var viewModel: BrowseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrowseBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchResults =
            arguments?.getSerializable("searchResults") as ArrayList<GoogleSearch.Recipe>
        super.onViewCreated(view, savedInstanceState)
//        dataInitialize()
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView = view.findViewById(R.id.rvBrowse)
        recyclerView.layoutManager = layoutManager
        adapter = MyAdapter(searchResults)
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this).get(BrowseViewModel::class.java)


    }

    private fun dataInitialize(){

        recipesArrayList = arrayListOf()

        imageId = arrayOf(
            R.drawable.burger_small,
            R.drawable.fisheye,
            R.drawable.world,
            R.drawable.fisheye,
            R.drawable.burger_yum,
            R.drawable.ant_eye
        )

        recipe= arrayOf(
            getString(R.string.Hollandaise),
            getString(R.string.yoghurt),
            getString(R.string.Toast),
            getString(R.string.title4),
            getString(R.string.title5),
            getString(R.string.title6)
        )

        title = arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title3),
            getString(R.string.title4),
            getString(R.string.title5),
            getString(R.string.title6)
        )

        for (i in imageId.indices){

            val foodImage = Recipes(imageId[i], recipe[i], title[i])
            recipesArrayList.add(foodImage)
        }

    }

}