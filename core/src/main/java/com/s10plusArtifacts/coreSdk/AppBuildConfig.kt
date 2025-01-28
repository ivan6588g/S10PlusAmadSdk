package com.s10plusArtifacts.coreSdk

import com.s10plusArtifacts.coreSdk.BuildConfig.BUILD_TYPE
import com.s10plusArtifacts.coreSdk.utils.Constants.BUILD_QA

object AppBuildConfig {
    const val BASE_URL= BuildConfig.BASE_URL
    const val BASE_URL_SEPOMEX = BuildConfig.BASE_URL_SEPOMEX

    fun isReleaseDebug() = BuildConfig.DEBUG && (BUILD_TYPE == BUILD_QA)
}