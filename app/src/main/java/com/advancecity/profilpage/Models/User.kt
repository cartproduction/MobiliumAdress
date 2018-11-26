package com.advancecity.profilpage.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("userId")
    @Expose
    var userId: Int? = null
    @SerializedName("username")
    @Expose
    var username: String? = null
    @SerializedName("profilePictureUrl")
    @Expose
    var profilePictureUrl: String? = null
    @SerializedName("profileBackgroundPictureUrl")
    @Expose
    var profileBackgroundPictureUrl: String? = null

}
