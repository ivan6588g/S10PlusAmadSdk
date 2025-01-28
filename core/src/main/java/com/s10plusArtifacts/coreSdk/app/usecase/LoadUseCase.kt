package com.s10plusArtifacts.coreSdk.app.usecase

import com.s10plusArtifacts.coreSdk.app.domain.entities.TokenRequestModel
import com.s10plusArtifacts.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plusArtifacts.coreSdk.app.mapper.LoadMapper
import com.s10plusArtifacts.coreSdk.bases.SuspendUseCase
import com.s10plusArtifacts.coreSdk.di.IoDispatcher
import com.s10plusArtifacts.coreSdk.network.BaseModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoadUseCase @Inject constructor(
    private val principalRepositoryDataSource: PrincipalRepositoryDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper: LoadMapper
) : SuspendUseCase<TokenRequestModel,String,BaseModel<Nothing>>(dispatcher,mapper){
    override suspend fun execute(params: TokenRequestModel): Result<BaseModel<Nothing>> =
        principalRepositoryDataSource.load(params)
}