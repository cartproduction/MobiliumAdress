package com.mobilium.profilpage.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mobilium.profilpage.Model.ProductItem
import com.mobilium.profilpage.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemproduct.view.*

class ProductRecyclerViewAdapter(private val horizontalGrocderyList: List<ProductItem>, internal var context: Context) : RecyclerView.Adapter<ProductRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemproduct, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl!!).into(holder.productimage);
        Picasso.with(context).load(horizontalGrocderyList[position].color!!).into(holder.color);
        Picasso.with(context).load(horizontalGrocderyList[position].size!!).into(holder.size);
        holder.title.setText(horizontalGrocderyList[position].name)
        holder.description.setText(horizontalGrocderyList[position].description)
        holder.price.setText(horizontalGrocderyList[position].price)
    }

    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var productimage: ImageView
        internal var color: ImageView
        internal var size: ImageView
        internal var title: TextView
        internal var description: TextView
        internal var price: TextView


        init {
            title = view.textView2
            description = view.textView4
            price = view.textView14
            productimage = view.imageView
            color = view.imageView13
            size = view.imageView14
        }
    }
}