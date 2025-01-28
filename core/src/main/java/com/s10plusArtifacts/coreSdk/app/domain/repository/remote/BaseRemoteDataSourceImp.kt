package com.s10plusArtifacts.coreSdk.app.domain.repository.remote

import com.s10plusArtifacts.coreSdk.app.domain.entities.TokenRequestModel
import com.s10plusArtifacts.coreSdk.app.domain.model.RequestClick
import com.s10plusArtifacts.coreSdk.app.domain.model.ResponceMunicipiosSepoMex
import com.s10plusArtifacts.coreSdk.app.domain.model.ResponseColoniaSepoMex
import com.s10plusArtifacts.coreSdk.app.domain.model.ResponseStatesSepoMex
import com.s10plusArtifacts.coreSdk.app.domain.services.BaseService
import com.s10plusArtifacts.coreSdk.app.domain.services.BaseServiceSepoMex
import com.s10plusArtifacts.coreSdk.componets.bases.BaseRemoteDataSource
import com.s10plusArtifacts.coreSdk.network.BaseModel
import com.s10plusArtifacts.coreSdk.utils.Configuration
import com.s10plusArtifacts.coreSdk.utils.DynamicServiceManager
import javax.inject.Inject

class BaseRemoteDataSourceImp @Inject constructor(
    private val baseServiceSepo: BaseServiceSepoMex
): BasePrincipalRemoteDataSource,BaseRemoteDataSource() {
    private val baseService: BaseService
        get() = DynamicServiceManager.createService(BaseService::class.java)

    override suspend fun getConfig(
        id: String
    ): Result<BaseModel<Configuration>> =
        getResult { baseService.getConfig(id) }


    override suspend fun load(token: TokenRequestModel): Result<BaseModel<Nothing>> =
        getResult { baseService.load(token) }

    override suspend fun getStatesSepoMex(): Result<List<ResponseStatesSepoMex>> =
        getResult { baseServiceSepo.getAllState() }

    override suspend fun getMunicipio(id: String): Result<List<ResponceMunicipiosSepoMex>> =
        getResult { baseServiceSepo.getMunicipioXEstado(id = id) }

    override suspend fun getColonia(id: String): Result<List<ResponseColoniaSepoMex>> =
        getResult { baseServiceSepo.getColoniasXMunicipios(id = id) }

    override suspend fun click(request: RequestClick): Result<BaseModel<Any>> =
        getResult { baseService.sendClick(request.token,request.rq) }


}