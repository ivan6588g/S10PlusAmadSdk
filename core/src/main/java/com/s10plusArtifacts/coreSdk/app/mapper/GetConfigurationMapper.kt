package com.s10plusArtifacts.coreSdk.app.mapper

import com.s10plusArtifacts.coreSdk.bases.Mapper
import com.s10plusArtifacts.coreSdk.network.BaseModel
import com.s10plusArtifacts.coreSdk.utils.Configuration
import javax.inject.Inject

class GetConfigurationMapper @Inject constructor():
    Mapper<BaseModel<Configuration>, Configuration>() {
    override fun map(info: BaseModel<Configuration>): Configuration {
        return info.data
    }
}