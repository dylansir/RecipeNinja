package com.example.restaurantreview

data class RecipeList(val recipeName: String) {
    operator fun get(rando: Int): String {
        return recipeName
    }
}


