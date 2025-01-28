package com.s10plusArtifacts.coreSdk.network

import com.s10plusArtifacts.coreSdk.AppBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object urlProvidesModule {
@Provides
@AmadUrl
fun providesBaseUrl() = AppBuildConfig.BASE_URL

@Provides
@AmadSepoMex
fun providesBaseUrlSepoMex() = AppBuildConfig.BASE_URL_SEPOMEX

}