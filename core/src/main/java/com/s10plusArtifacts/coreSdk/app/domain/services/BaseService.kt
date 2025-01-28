package com.s10plusArtifacts.coreSdk.app.domain.services

import com.s10plusArtifacts.coreSdk.app.domain.entities.TokenRequestModel
import com.s10plusArtifacts.coreSdk.app.domain.model.RequestAnalytics
import com.s10plusArtifacts.coreSdk.network.BaseModel
import com.s10plusArtifacts.coreSdk.utils.Configuration
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface BaseService {


    @GET(BaseEndPoint.GETCONFIG)
    suspend fun getConfig(@Path("id") id: String):BaseModel<Configuration>
    @POST(BaseEndPoint.LOAD)
    suspend fun load(@Body mainRequest: TokenRequestModel): BaseModel<Nothing>
    @POST(BaseEndPoint.SEND_CLICKS)
    suspend fun sendClick(
        @Header("token") token:String,
        @Body RQ:RequestAnalytics): BaseModel<Any>

}