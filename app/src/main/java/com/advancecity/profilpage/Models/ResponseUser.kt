package com.advancecity.profilpage.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseUser {

    @SerializedName("Result")
    @Expose
    var result: User? = null
    @SerializedName("IsSuccess")
    @Expose
    var isSuccess: Boolean? = null
    @SerializedName("Errors")
    @Expose
    var errors: List<Any>? = null

}