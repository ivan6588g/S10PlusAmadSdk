package com.s10plus.coreSdk.app.usecase

import com.s10plus.coreSdk.app.domain.model.RequestClick
import com.s10plus.coreSdk.app.domain.repository.PrincipalRepositoryDataSource
import com.s10plus.coreSdk.app.mapper.ClickMapper
import com.s10plus.coreSdk.bases.SuspendUseCase
import com.s10plus.coreSdk.di.IoDispatcher
import com.s10plus.coreSdk.network.BaseModel
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