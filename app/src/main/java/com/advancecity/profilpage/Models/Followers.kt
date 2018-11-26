package com.advancecity.profilpage.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Followers {

    @SerializedName("userId")
    @Expose
    var userId: String? = null
    @SerializedName("profilePictureUrl")
    @Expose
    var profilePictureUrl: String? = null

}