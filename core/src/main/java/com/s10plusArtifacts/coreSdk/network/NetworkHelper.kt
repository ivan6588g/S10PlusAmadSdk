package com.s10plusArtifacts.coreSdk.network

import com.s10plusArtifacts.coreSdk.network.interceptors.logging.Level
import com.s10plusArtifacts.coreSdk.network.interceptors.logging.LoggingInterceptor
import com.s10plusArtifacts.coreSdk.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkHelper {


    fun getOkHttpBuilder() = OkHttpClient.Builder().apply {


        connectTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
        readTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(Constants.TIMEOUT, TimeUnit.SECONDS)
        addInterceptor(
            LoggingInterceptor.Builder()
                .setLevel(Level.BASIC)
                .build()
        )
    }

    fun getRetrofitBuilder() = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())

    inline fun <reified T : Any> provideService(
        okHttpClient: OkHttpClient,
        url: String
    ): T = getRetrofitBuilder().baseUrl(url).client(okHttpClient).build().create(T::class.java)
}