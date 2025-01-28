package com.s10plusArtifacts.coreSdk.utils

data class ActionObject(
    var acction: ActionEnum =ActionEnum.NOTHING,
    var value : List<String> = arrayListOf()
)
