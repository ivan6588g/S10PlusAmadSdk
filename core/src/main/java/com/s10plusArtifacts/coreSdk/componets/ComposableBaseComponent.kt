package com.s10plusArtifacts.coreSdk.componets

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.s10plusArtifacts.coreSdk.utils.Actions

@Composable
fun ComposableBaseComponent(
    element:@Composable () -> Unit,
    onClick: ((id: String?) -> Unit),
    actions: Actions? = null){
    var context = LocalContext.current

        element.invoke()
    


}