package com.s10plus.coreSdk.app.domain.model

import com.google.gson.annotations.SerializedName

data class ResponseStatesSepoMex(
    @SerializedName("id_estado")
    var id_estado:Int,
    @SerializedName("estado")
    var estado:String,

)
