package com.mobilium.profilpage.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SpecifyItem(name: String, profilePictureUrl: Int) {

    @SerializedName("name")
    @Expose
    var name: String? = name
    @SerializedName("profilePictureUrl")
    @Expose
    var profilePictureUrl: Int? = profilePictureUrl

}