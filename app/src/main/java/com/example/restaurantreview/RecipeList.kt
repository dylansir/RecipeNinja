package com.example.restaurantreview

data class RecipeList(val recipeName: String) {
    operator fun get(rnds: Int): String {
        return recipeName
    }
}


