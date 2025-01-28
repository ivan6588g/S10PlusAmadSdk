package com.s10plus.coreSdk

import com.s10plus.coreSdk.BuildConfig.BUILD_TYPE
import com.s10plus.coreSdk.utils.Constants.BUILD_QA

object AppBuildConfig {
    const val BASE_URL= BuildConfig.BASE_URL
    const val BASE_URL_SEPOMEX = BuildConfig.BASE_URL_SEPOMEX

    fun isReleaseDebug() = BuildConfig.DEBUG && (BUILD_TYPE == BUILD_QA)
}