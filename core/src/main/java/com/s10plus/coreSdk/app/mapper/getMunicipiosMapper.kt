package com.s10plus.coreSdk.app.mapper

import com.s10plus.coreSdk.app.domain.model.ResponceMunicipiosSepoMex
import com.s10plus.coreSdk.bases.Mapper
import javax.inject.Inject

class getMunicipiosMapper @Inject constructor():
Mapper<List<ResponceMunicipiosSepoMex>,List<ResponceMunicipiosSepoMex>>(){
    override fun map(info: List<ResponceMunicipiosSepoMex>): List<ResponceMunicipiosSepoMex> {
        return info
    }
}