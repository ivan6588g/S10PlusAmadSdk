package com.s10plus.coreSdk.app.usecase

import com.s10plus.coreSdk.app.domain.model.ResponseStatesSepoMex
import com.s10plus.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plus.coreSdk.app.mapper.GetAllStateSepo
import com.s10plus.coreSdk.bases.SuspendUseCase
import com.s10plus.coreSdk.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetAllStateSepo @Inject constructor(
    private val principalRepositoryDataSource: PrincipalRepositoryDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher,
    mapper: GetAllStateSepo
    ): SuspendUseCase<String,List<ResponseStatesSepoMex>,List<ResponseStatesSepoMex>>(dispatcher,mapper) {
    override suspend fun execute(params: String): Result<List<ResponseStatesSepoMex>> =
        principalRepositoryDataSource.getStateSepo()
}