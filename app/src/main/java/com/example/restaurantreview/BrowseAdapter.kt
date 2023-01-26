package com.example.restaurantreview

import android.content.Intent
import android.graphics.Insets.add
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyAdapter(private val recipes : ArrayList<GoogleSearching.Recipe>?) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.list_item,
            parent, false
        )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (recipes!=null)
            recipes!!.size
        else
            0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val currentItem = recipes!![position]

            holder.itemView.apply {
                var imageTing = findViewById<ImageView>(R.id.cvImage)
                var textTing = findViewById<TextView>(R.id.tvName)
                var btnRecipe = findViewById<Button>(R.id.btnRecipeLink)
                val link = recipes[position].url


                imageTing.setImageDrawable(ContextCompat.getDrawable(context, recipes[position].localImage))
                textTing.text = recipes[position].title
                btnRecipe.setOnClickListener {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                    context.startActivity(browserIntent)
                }
            }
        }
    }



    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = itemView.findViewById(R.id.cvImage)
        val text: TextView = itemView.findViewById(R.id.tvName)
        val btnRecipe: Button = itemView.findViewById(R.id.btnRecipeLink)
    }
}
