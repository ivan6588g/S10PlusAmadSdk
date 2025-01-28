package com.s10plus.coreSdk.app.usecase

import com.s10plus.coreSdk.app.domain.entities.TokenRequestModel
import com.s10plus.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plus.coreSdk.app.mapper.LoadMapper
import com.s10plus.coreSdk.bases.SuspendUseCase
import com.s10plus.coreSdk.di.IoDispatcher
import com.s10plus.coreSdk.network.BaseModel
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