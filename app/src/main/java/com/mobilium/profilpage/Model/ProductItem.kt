package com.mobilium.profilpage.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductItem(name: String,description: String,price: String,profilePictureUrl: Int,color: Int,size: Int) {

    @SerializedName("name")
    @Expose
    var name: String? = name
    @SerializedName("description")
    @Expose
    var description: String? = description
    @SerializedName("price")
    @Expose
    var price: String? = price
    @SerializedName("profilePictureUrl")
    @Expose
    var profilePictureUrl: Int? = profilePictureUrl
    @SerializedName("color")
    @Expose
    var color: Int? = color
    @SerializedName("size")
    @Expose
    var size: Int? = size

}