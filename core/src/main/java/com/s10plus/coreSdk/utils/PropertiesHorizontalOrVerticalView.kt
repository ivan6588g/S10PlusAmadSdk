package com.s10plus.coreSdk.utils

import androidx.compose.ui.graphics.Color

data class PropertiesHorizontalOrVerticalView(
    val type:String,
    val height:Int = 0,
    val width: Int = 0,
    val backGround:Color = Color.Transparent,
)
