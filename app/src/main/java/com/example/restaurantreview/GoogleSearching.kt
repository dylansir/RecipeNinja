package com.example.restaurantreview
import android.media.Image
import com.google.gson.Gson
import java.net.URL
import android.util.Log


class GoogleSearching(recipe: String) {

    class Recipe(val title: String, val image: String?, val url:String?, val localImage: Int)


    val apiKey = R.string.API_KEY
    val serviceId = R.string.service_account_id

    val searchResults = googleSearch(refineSearch(recipe))

    private fun refineSearch(recipe:String):String{

        Log.i("GOOGLE11", "refineSearch $recipe" )
        val lowerCaseInput = recipe.lowercase()
        val cleanedInput = lowerCaseInput.replace("\\s+".toRegex(), " ")
        Log.i("GOOGLE11", "after it got cleaned $cleanedInput")
        return cleanedInput.trim()
    }

    private fun googleSearch(recipe:String):ArrayList<Recipe>{
        Log.i("GOOGLE11", "googleSearch")

        val recipes = ArrayList<Recipe>()
//        val url = "https://www.googleapis.com/customsearch/v1?key=$apiKey&cx=$serviceId&q=$recipe"
//        val json = URL(url).readText()
//
//        try {
//            val searchResults = Gson().fromJson(json, SearchResults::class.java)

            var counter = 0
            Log.i("GOOGLE11", "if it got passed the parse")

//            if (searchResults.items == null) {
                Log.i("GOOGLE11", "null, ")


                //populate the array with local files or strings
                val recipe1 = Recipe("Caramelized Cinnamon Spiced Pears",
                    "https://minimalistbaker.com/wp-content/uploads/2022/10/Caramelized-Spiced-Pears-4.jpg",
                    "https://minimalistbaker.com/caramelized-cinnamon-spiced-pears/",
                    R.drawable.caramalized_pears)
                val recipe2 = Recipe("Chana Masala",
                    "https://minimalistbaker.com/wp-content/uploads/2016/02/AMAZING-Chana-Masala-made-in-1-Pot-So-healthy-flavorful-and-delicious-vegan-glutenfree-chanamasala-recipe-minimalistbaker.jpg",
                    "https://minimalistbaker.com/easy-chana-masala/",
                   R.drawable.chana_masla)
                val recipe3 = Recipe("Miso Pumpkin Risotto",
                    "https://minimalistbaker.com/wp-content/uploads/2021/09/CREAMY-Pumpkin-Risotto-V-GF-Infused-with-miso-topped-with-crispy-sage-and-just-9-ingredients-required-minimalistbaker-recipe-plantbased-glutenfree-pumpkin-risotto-5.jpg",
                    "https://minimalistbaker.com/miso-pumpkin-risotto-with-crispy-sage/",
                    R.drawable.rissoto)
                val recipe4 = Recipe("Pumpkin Peanut Butter Breakfast Cookies",
                    "https://minimalistbaker.com/wp-content/uploads/2022/07/Pumpkin-Peanut-Butter-BREAKFAST-Cookies-Vegan-gluten-free-10-ingredients-30-minutes-minimalistbaker-recipe-pumpkin-peanutbutter-breakfast-cookie-8.jpg",
                    "https://minimalistbaker.com/pumpkin-peanut-butter-breakfast-cookies/",
                    R.drawable.cookies)
                val recipe5 = Recipe("Vegan Tiramisu Pudding",
                    "https://minimalistbaker.com/wp-content/uploads/2022/07/CREAMY-vegan-pudding-infused-with-the-flavors-of-tiramisu-An-EASY-decadent-no-bake-dessert-made-with-just-7-simple-ingredients.-minimalistbaker-recipe-plantbased-tiramisu-pudding-7.jpg",
                    "https://minimalistbaker.com/vegan-tiramisu-pudding/",
                    R.drawable.pudding)
                val recipe6 = Recipe("Palak Paneer",
                    "https://minimalistbaker.com/wp-content/uploads/2018/10/AMAZING-Vegan-Palak-Paneer-with-Tofu-30-minutes-wholesome-ingredients-EASY-BIG-flavor-vegan-glutenfree-palakpaneer-tofu-curry-minimalistbaker-recipe-11.jpg",
                    "https://minimalistbaker.com/vegan-palak-paneer-with-curried-tofu/",
                    R.drawable.paneer_alak)

                recipes.add(recipe1)
                recipes.add(recipe2)
                recipes.add(recipe3)
                recipes.add(recipe4)
                recipes.add(recipe5)
                recipes.add(recipe6)


//            } else {
//                for (item in searchResults.items!!) {
//                    val recipeItem = Recipe(item.title!!, item.link!!, item.image!!, null)
//                    recipes.add(recipeItem)
//                    counter++
//                    if (counter >= 5) {
//                        Log.i("GOOGLE11", "$counter, $recipeItem counting")
//                        break
//                    }
//                    Log.i("GOOGLE11", "$recipeItem, if it worked?")
//                }
//
//            }
//        }
//        catch (e: Exception) {
//            Log.e("GOOGLE11", "Error: $e")
//        }

        Log.i("GOOGLE11", "after API call")

        return recipes
    }

}

