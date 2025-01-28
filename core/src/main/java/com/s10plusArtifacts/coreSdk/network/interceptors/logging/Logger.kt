package com.s10plusArtifacts.coreSdk.network.interceptors.logging

import okhttp3.internal.platform.Platform.Companion.INFO

interface Logger {
    fun log(level: Int = INFO, tag: String? = null, msg: String? = null)
}