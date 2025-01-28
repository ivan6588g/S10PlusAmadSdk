package com.s10plus.coreSdk.componets.Dialogs

import com.s10plus.coreSdk.utils.Constants

data class DialogModel(
    val title:String = Constants.EMPTY_STRING,
    val subTitle:String = Constants.EMPTY_STRING,
    val txtButton1:String = Constants.EMPTY_STRING,
    val txtButton2:String = Constants.EMPTY_STRING
)
