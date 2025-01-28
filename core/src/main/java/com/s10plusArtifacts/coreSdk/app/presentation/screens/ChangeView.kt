package com.s10plusArtifacts.coreSdk.app.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.s10plusArtifacts.coreSdk.app.presentation.viewmodels.ChangeViewModel
import com.s10plusArtifacts.coreSdk.utils.ComponentConvert

@Composable
fun ChangeView(viewmodel: ChangeViewModel = hiltViewModel(), id: String) {
    val list:MutableList<ComponentConvert> by viewmodel.componentsFromJson.observeAsState(initial = mutableListOf())


    if(list.isNotEmpty()){
      /*  ComposableViewBase(arrayElements = list, viewModel = viewmodel){
                id ->
            Log.i("","")

        }*/
    }else{
        viewmodel.getView(id)
    }
}