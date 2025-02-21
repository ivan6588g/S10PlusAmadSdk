package com.s10plusArtifacts.coreSdk.componets.Dialogs

import com.s10plusArtifacts.coreSdk.utils.Constants

data class DialogModel(
    val title:String = Constants.EMPTY_STRING,
    val subTitle:String = Constants.EMPTY_STRING,
    val txtButton1:String = Constants.EMPTY_STRING,
    val txtButton2:String = Constants.EMPTY_STRING
)
