package com.example.restaurantreview
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jsoup.Jsoup
import java.net.URL


class GoogleSearch(recipe: String) {

    class Recipe(val title: String, val image: String, val url:String)
    val apiKey = R.string.API_KEY

    class SearchResults {
        var items: List<Item>? = null
    }

    class Item {
        var title: String? = null
        var link: String? = null
        var image: String? = null
    }

    val searchResults = googleSearch(refineSearch(recipe))

    private fun refineSearch(recipe:String):String{
        val lowerCaseInput = recipe.toLowerCase()
        val cleanedInput = lowerCaseInput.replace("\\s+".toRegex(), " ")
        return cleanedInput.trim()
    }

    private fun googleSearch(recipe:String):ArrayList<Recipe>{
        val url = "https://www.googleapis.com/customsearch/v1?key=$apiKey&cx=$@strings/service_account_id&q=$recipe"
        val json = URL(url).readText()
        val searchResults = Gson().fromJson(json, SearchResults::class.java)
        val recipes = ArrayList<Recipe>()
        var counter = 0

        if (searchResults.items == null) {
            return ArrayList()
        } else {
            for (item in searchResults.items!!) {
                val recipe = Recipe(item.title!!, item.link!!, item.image!!)
                recipes.add(recipe)
                counter++
                if (counter >= 5) {
                    break
                }
            }
            return recipes
        }
    }

//searchResults.items?.get(0)?.image
}



//    val jsonString = "Your JSON string here"
//    val gson = Gson()
//    val type = object : TypeToken<List<Recipe>>() {}.type
//    val recipes = gson.fromJson<List<Recipe>>(jsonString, type)
//
//    for (recipe in recipes) {
//        println(recipe.method)
//    }