package com.advancecity.profilpage.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoviesCollection {

    @SerializedName("ItemCount")
    @Expose
    var itemCount: Int? = null
    @SerializedName("Items")
    @Expose
    var items: List<Movies>? = null

}