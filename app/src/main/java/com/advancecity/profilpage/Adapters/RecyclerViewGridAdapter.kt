package com.advancecity.profilpage.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.advancecity.profilpage.Models.Movies
import com.advancecity.profilpage.R
import kotlinx.android.synthetic.main.itemmovies.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemmovies.view.*

class RecyclerViewGridAdapter(private val horizontalGrocderyList: List<Movies>, internal var context: Context) : RecyclerView.Adapter<RecyclerViewGridAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemmovies, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl).into(holder.imageView);
        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl).into(holder.background);
        holder.title.setText(horizontalGrocderyList[position].name)
        holder.count.setText(horizontalGrocderyList[position].likeCount.toString())
    }

    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var imageView: ImageView
        internal var background: ImageView
        internal var title: TextView
        internal var count: TextView


        init {
            title = view.textView2
            imageView = view.imageView2
            background = view.imageView3
            count = view.textView4
        }
    }
}