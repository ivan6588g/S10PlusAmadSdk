package com.s10plusArtifacts.coreSdk.app.usecase

import com.s10plusArtifacts.coreSdk.app.domain.model.ResponseColoniaSepoMex
import com.s10plusArtifacts.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plusArtifacts.coreSdk.app.mapper.getColoniasMapper
import com.s10plusArtifacts.coreSdk.bases.SuspendUseCase
import com.s10plusArtifacts.coreSdk.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetColoniasUseCase @Inject constructor(
    private val principalRepositoryDataSource: PrincipalRepositoryDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper: getColoniasMapper
): SuspendUseCase<String,List<ResponseColoniaSepoMex>,List<ResponseColoniaSepoMex>>(dispatcher,mapper) {
    override suspend fun execute(params: String): Result<List<ResponseColoniaSepoMex>> =
        principalRepositoryDataSource.getColoniasSepo(params)

}