package com.s10plus.coreSdk.app.mapper

import com.s10plus.coreSdk.bases.Mapper
import com.s10plus.coreSdk.network.BaseModel
import com.s10plus.coreSdk.utils.Configuration
import javax.inject.Inject

class GetConfigurationMapper @Inject constructor():
    Mapper<BaseModel<Configuration>, Configuration>() {
    override fun map(info: BaseModel<Configuration>): Configuration {
        return info.data
    }
}