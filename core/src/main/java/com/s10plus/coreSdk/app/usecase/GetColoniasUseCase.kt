package com.s10plus.coreSdk.app.usecase

import com.s10plus.coreSdk.app.domain.model.ResponseColoniaSepoMex
import com.s10plus.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plus.coreSdk.app.mapper.getColoniasMapper
import com.s10plus.coreSdk.bases.SuspendUseCase
import com.s10plus.coreSdk.di.IoDispatcher
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