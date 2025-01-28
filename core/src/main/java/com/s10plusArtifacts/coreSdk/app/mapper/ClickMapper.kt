package com.s10plusArtifacts.coreSdk.app.mapper

import com.s10plusArtifacts.coreSdk.bases.Mapper
import com.s10plusArtifacts.coreSdk.network.BaseModel
import javax.inject.Inject

class ClickMapper @Inject constructor():
Mapper<BaseModel<Any>,BaseModel<Any>>(){
    override fun map(info: BaseModel<Any>): BaseModel<Any> {
        return  info
    }
}