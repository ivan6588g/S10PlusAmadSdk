package com.s10plus.coreSdk.app.mapper

import com.s10plus.coreSdk.app.domain.model.ResponseColoniaSepoMex
import com.s10plus.coreSdk.bases.Mapper
import javax.inject.Inject

class getColoniasMapper @Inject constructor():
    Mapper<List<ResponseColoniaSepoMex>, List<ResponseColoniaSepoMex>>(){
    override fun map(info: List<ResponseColoniaSepoMex>): List<ResponseColoniaSepoMex> {
        return info
    }
}