package com.s10plus.coreSdk.app.domain.repository.remote

import com.s10plus.coreSdk.app.domain.entities.TokenRequestModel
import com.s10plus.coreSdk.app.domain.model.RequestClick
import com.s10plus.coreSdk.app.domain.model.ResponceMunicipiosSepoMex
import com.s10plus.coreSdk.app.domain.model.ResponseColoniaSepoMex
import com.s10plus.coreSdk.app.domain.model.ResponseStatesSepoMex
import com.s10plus.coreSdk.network.BaseModel
import com.s10plus.coreSdk.utils.Configuration

interface BasePrincipalRemoteDataSource {

    suspend fun getConfig(id:String):Result<BaseModel<Configuration>>
    suspend fun load(token: TokenRequestModel):Result<BaseModel<Nothing>>
    suspend fun getStatesSepoMex():Result<List<ResponseStatesSepoMex>>
    suspend fun getMunicipio(id:String):Result<List<ResponceMunicipiosSepoMex>>
    suspend fun getColonia(id:String):Result<List<ResponseColoniaSepoMex>>
    suspend fun click(request:RequestClick):Result<BaseModel<Any>>

}