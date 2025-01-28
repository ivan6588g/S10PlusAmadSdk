package com.s10plusArtifacts.coreSdk.app.usecase

import com.s10plusArtifacts.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plusArtifacts.coreSdk.app.mapper.GetConfigurationMapper
import com.s10plusArtifacts.coreSdk.bases.SuspendUseCase
import com.s10plusArtifacts.coreSdk.di.IoDispatcher
import com.s10plusArtifacts.coreSdk.network.BaseModel
import com.s10plusArtifacts.coreSdk.utils.Configuration
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetConfigurationUseCase @Inject constructor(
    private val principalRepositoryDataSource: PrincipalRepositoryDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper: GetConfigurationMapper
):SuspendUseCase<String,Configuration,BaseModel<Configuration>>(dispatcher,mapper){
    override suspend fun execute(params: String): Result<BaseModel<Configuration>> =
        principalRepositoryDataSource.getConfiguration(params)
}