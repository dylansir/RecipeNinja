package com.example.restaurantreview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val recipes : ArrayList<Recipes>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recipes[position]
        holder.image.setImageResource(currentItem.image)
        holder.text.text = currentItem.recipe
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image : ImageView = itemView.findViewById(R.id.cvImage)
        val text : TextView = itemView.findViewById(R.id.tvName)
        val btnRecipe : Button = itemView.findViewById(R.id.btnRecipeLink)

        private fun onButtonClick(){
            btnRecipe.setOnClickListener {
                Navigation.findNavController(view).navigate(BrowseDirections.actionBrowseToRecipeFragment())
            }
        }
    }

}