package com.s10plus.coreSdk.app.usecase

import com.s10plus.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plus.coreSdk.app.mapper.GetConfigurationMapper
import com.s10plus.coreSdk.bases.SuspendUseCase
import com.s10plus.coreSdk.di.IoDispatcher
import com.s10plus.coreSdk.network.BaseModel
import com.s10plus.coreSdk.utils.Configuration
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