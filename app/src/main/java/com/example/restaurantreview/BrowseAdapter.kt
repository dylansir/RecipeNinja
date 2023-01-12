package com.example.restaurantreview

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyAdapter(private val recipes : ArrayList<GoogleSearch.Recipe>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent, false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val currentItem = recipes[position]
            Glide.with(holder.itemView.context)
                .load(currentItem.image)
                .into(holder.image)
            holder.text.text = currentItem.title
        }
//        holder.btnRecipe.setOnClickListener {
//            val url = currentItem.url
//            val bundle = Bundle()
//            bundle.putString("url", url)
//            val newFragment = RecipeFragment()
//            newFragment.arguments = bundle
//            val fragmentManager = (holder.itemView.context as Activity).supportFragmentManager
//            fragmentManager.beginTransaction().replace(R.id.fragmentBrowse, newFragment).commit()
//        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = itemView.findViewById(R.id.cvImage)
        val text: TextView = itemView.findViewById(R.id.tvName)
        val btnRecipe: Button = itemView.findViewById(R.id.btnRecipeLink)


    }
}
