package com.s10plus.coreSdk.app.mapper

import com.s10plus.coreSdk.bases.Mapper
import com.s10plus.coreSdk.network.BaseModel
import javax.inject.Inject

class ClickMapper @Inject constructor():
Mapper<BaseModel<Any>,BaseModel<Any>>(){
    override fun map(info: BaseModel<Any>): BaseModel<Any> {
        return  info
    }
}