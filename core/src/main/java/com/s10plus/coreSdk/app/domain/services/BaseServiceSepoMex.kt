package com.s10plus.coreSdk.app.domain.services

import com.s10plus.coreSdk.app.domain.model.ResponceMunicipiosSepoMex
import com.s10plus.coreSdk.app.domain.model.ResponseColoniaSepoMex
import com.s10plus.coreSdk.app.domain.model.ResponseStatesSepoMex
import com.s10plus.coreSdk.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface BaseServiceSepoMex {

    @GET(BaseEndPointSepoMex.GETLISTALLSTATE)
    suspend fun getAllState(@Header("api-key") key:String = Constants.KEY_SEPO):List<ResponseStatesSepoMex>

    @GET(BaseEndPointSepoMex.listaMunicipiosXEstado)
    suspend fun getMunicipioXEstado(@Header("api-key") key:String = Constants.KEY_SEPO,
                                    @Path("id") id: String):List<ResponceMunicipiosSepoMex>

    @GET(BaseEndPointSepoMex.listaColoniasXMunicipio)
    suspend fun getColoniasXMunicipios(@Header("api-key") key:String = Constants.KEY_SEPO,
                                       @Path("id") id: String):List<ResponseColoniaSepoMex>
}
