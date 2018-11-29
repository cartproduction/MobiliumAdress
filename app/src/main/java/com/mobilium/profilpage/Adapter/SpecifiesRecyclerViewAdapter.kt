package com.mobilium.profilpage.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mobilium.profilpage.Model.SpecifyItem
import com.mobilium.profilpage.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemspecify.view.*

class SpecifiesRecyclerViewAdapter(private val horizontalGrocderyList: List<SpecifyItem>, internal var context: Context) : RecyclerView.Adapter<SpecifiesRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemspecify, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl!!).into(holder.productimage);
        holder.title.setText(horizontalGrocderyList[position].name)
    }

    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var productimage: ImageView
        internal var title: TextView


        init {
            title = view.textView15
            productimage = view.imageView2
        }
    }
}