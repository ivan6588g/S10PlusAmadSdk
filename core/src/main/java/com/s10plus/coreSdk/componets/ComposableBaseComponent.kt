package com.s10plus.coreSdk.componets

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.s10plus.coreSdk.utils.Actions

@Composable
fun ComposableBaseComponent(
    element:@Composable () -> Unit,
    onClick: ((id: String?) -> Unit),
    actions: Actions? = null){
    var context = LocalContext.current

        element.invoke()
    


}