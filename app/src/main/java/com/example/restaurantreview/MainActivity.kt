package com.example.restaurantreview

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import com.example.restaurantreview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var recipeList: RecipeList

    private var displayFragment = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        binding.btnRandom.setOnClickListener() {
            CoroutineScope(Dispatchers.IO).launch {
                Log.i("MYTAG", "Random button clicked")
                //Search(Random())
            }
        }

        binding.btnFavourites.setOnClickListener() {
            CoroutineScope(Dispatchers.IO).launch {
                Log.i("MYTAG", "Favourites Clicked")
                //Favourites()
            }
        }



        binding.btnSearch.setOnClickListener() {
            var recipeSearch = binding.etSearch.toString()
            Log.i("MYTAG", "Search Button clicked")
            if (recipeSearch.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please add in a name of a dish you'd like to make",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Search(binding.etSearch.toString())
            }
        }

    }

    private fun fragmentDisplay() {

        supportFragmentManager.commit {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = Browse()
            fragmentTransaction.replace(R.id.fragmentBrowse, fragment)
            fragmentTransaction.commit()
        }

    }


    private fun Search(recipe: String) {

        //implement google search API
//            return JsonList
    }

    private fun Random(): String {

        val rando = (0..15).random()
        return recipeList[rando]
    }


    private fun Favourites() {
        Navigation.findNavController(binding.btnFavourites)
            .navigate(MainActivityDirections.actionMainActivityToFavouritesFragment())

    }


    private fun initiliazieArray() {
        var recipeListArray = listOf<RecipeList>(
            RecipeList("Guacamole"),
            RecipeList("Chicken Casserole"),
            RecipeList("Bolognese Sauce"),
            RecipeList("Mac and Cheese"),
            RecipeList("Italian Pizza Dough"),
            RecipeList("Lasagne"),
            RecipeList("Chicken Tikka"),
            RecipeList("Chana Masala"),
            RecipeList("Hollandaise"),
            RecipeList("Sourdough"),
            RecipeList("Kombucha"),
            RecipeList("Greek Salad"),
            RecipeList("Mushroom Risotto"),
            RecipeList("Ratatouille")
        )
    }
}

