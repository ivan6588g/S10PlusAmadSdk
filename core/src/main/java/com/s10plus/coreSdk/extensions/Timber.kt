package com.s10plus.coreSdk.extensions

import com.s10plus.coreSdk.BuildConfig
import timber.log.Timber

fun Timber.Tree.logE(message:String,tag:String = BuildConfig.LIBRARY_PACKAGE_NAME) {
    Timber.tag(tag = tag).e(message = message )
}