package com.s10plus.coreSdk.app.mapper

import com.s10plus.coreSdk.bases.Mapper
import com.s10plus.coreSdk.network.BaseModel
import javax.inject.Inject

class LoadMapper @Inject constructor(): Mapper<BaseModel<Nothing>,String>() {
    override fun map(info: BaseModel<Nothing>): String {
        return info.token ?: ""
    }
}