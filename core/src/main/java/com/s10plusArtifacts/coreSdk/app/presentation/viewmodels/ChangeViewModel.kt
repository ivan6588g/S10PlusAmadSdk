package com.s10plusArtifacts.coreSdk.app.presentation.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.s10plusArtifacts.coreSdk.componets.bases.BaseViewModel
import com.s10plusArtifacts.coreSdk.sesion.SessionDelegateCore
import com.s10plusArtifacts.coreSdk.utils.ComponentConvert
import com.s10plusArtifacts.coreSdk.utils.ConvertComponent
import com.s10plusArtifacts.coreSdk.utils.View
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class ChangeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val sessionDelegate: SessionDelegateCore
): BaseViewModel(), SessionDelegateCore by sessionDelegate {
    private val _componentsFromJson = MutableLiveData<MutableList<ComponentConvert>>()
    var componentsFromJson: LiveData<MutableList<ComponentConvert>> = _componentsFromJson
    fun getView(idView:String){
        val gson = Gson()
        var listView = sessionDelegate.views
        if(views.isNotEmpty()){
            var arrayViews = gson.fromJson(views,Array<View>::class.java)
            arrayViews.forEach { view ->
                if(view.id == idView){
                    var convert =  ConvertComponent(view.component)
                    _componentsFromJson.value = convert
                }
            }

        }
    }
}