package com.s10plus.coreSdk.app.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseColoniaSepoMex(
    @SerializedName("id_colonia")
    var id_colonia:Int,
    @SerializedName("colonia")
    var colonia:String,
)
