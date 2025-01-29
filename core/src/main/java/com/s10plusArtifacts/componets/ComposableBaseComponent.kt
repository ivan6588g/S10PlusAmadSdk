package com.s10plusArtifacts.componets

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.s10plusArtifacts.utils.Actions

@SuppressLint("SuspiciousIndentation")
@Composable
fun ComposableBaseComponent(
    element:@Composable () -> Unit,
    onClick: ((id: String?) -> Unit),
    actions: Actions? = null){
    var context = LocalContext.current

        element.invoke()
    


}