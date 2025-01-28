package com.s10plus.coreSdk.extensions

import com.s10plus.coreSdk.network.BaseResponse
import com.s10plus.coreSdk.network.Errors
import com.s10plus.coreSdk.network.Success
import com.s10plus.coreSdk.utils.Constants

fun BaseResponse<*>.isSuccess() = response?.isSuccess ?: false
fun <T> BaseResponse<T>.getData(): T = response?.data ?: throw Exception("Not Found Data")
fun BaseResponse<*>.getErrors() = response?.errors ?: arrayListOf()
fun BaseResponse<*>.success() = response?.success ?: Success("", "")

fun ArrayList<Errors>.getLastError(): Errors =
    this.firstOrNull() ?: Errors(message = Constants.ERROR_TEXT_GENERIC)

