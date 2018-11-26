package com.advancecity.profilpage.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.advancecity.profilpage.Models.Followers
import com.advancecity.profilpage.R
import com.squareup.picasso.Picasso

class RecyclerViewHorizontalListAdapter(private val horizontalGrocderyList: List<Followers>, internal var context: Context) : RecyclerView.Adapter<RecyclerViewHorizontalListAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemfollowers, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl).into(holder.imageView);

    }

    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var imageView: ImageView

        init {
            imageView = view.findViewById(R.id.imageView2) as ImageView
        }
    }
}