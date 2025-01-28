package com.s10plusArtifacts.coreSdk.app.usecase

import com.s10plusArtifacts.coreSdk.app.domain.model.RequestClick
import com.s10plusArtifacts.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plusArtifacts.coreSdk.app.mapper.ClickMapper
import com.s10plusArtifacts.coreSdk.bases.SuspendUseCase
import com.s10plusArtifacts.coreSdk.di.IoDispatcher
import com.s10plusArtifacts.coreSdk.network.BaseModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ClickUseCase @Inject constructor(
    private val principalRepositoryDataSource: PrincipalRepositoryDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper:ClickMapper
) : SuspendUseCase<RequestClick, BaseModel<Any>,BaseModel<Any>>(dispatcher,mapper) {
    override suspend fun execute(params: RequestClick): Result<BaseModel<Any>> =
        principalRepositoryDataSource.click(params)

}