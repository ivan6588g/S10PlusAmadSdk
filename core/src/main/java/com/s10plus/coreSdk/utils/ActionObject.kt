package com.s10plus.coreSdk.utils

data class ActionObject(
    var acction: ActionEnum =ActionEnum.NOTHING,
    var value : List<String> = arrayListOf()
)
