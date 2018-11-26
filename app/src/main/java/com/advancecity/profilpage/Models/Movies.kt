package com.advancecity.profilpage.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movies {

    @SerializedName("Id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("profilePictureUrl")
    @Expose
    var profilePictureUrl: String? = null
    @SerializedName("isLiked")
    @Expose
    var isLiked: Boolean? = null
    @SerializedName("likeCount")
    @Expose
    var likeCount: Int? = null
    @SerializedName("createDate")
    @Expose
    var createDate: String? = null

}
