package com.s10plusArtifacts.coreSdk.componets.TextView

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.s10plusArtifacts.coreSdk.utils.Actions
import com.s10plusArtifacts.coreSdk.utils.AligmentEnum
import com.s10plusArtifacts.coreSdk.utils.ComponentProperties
import com.s10plusArtifacts.coreSdk.utils.DataAnalitic
import com.s10plusArtifacts.coreSdk.utils.HexToJetpackColor
import com.s10plusArtifacts.coreSdk.utils.ScalingUtils
import com.s10plusArtifacts.coreSdk.utils.getAligment

@Composable
fun TextViewComponent(
    propertiesTextViewComposable: ComponentProperties,
    actions:Actions?,
    onClick: (Actions,DataAnalitic) -> Unit
) {

    val (scaledWidth, scaledHeight) = ScalingUtils.scaleDimensionsToDp(
        width = propertiesTextViewComposable.size.width, // Ancho original
        height = propertiesTextViewComposable.size.height, // Alto original
        serviceWidth = 400f, // Ancho de referencia
        serviceHeight = 800f // Alto de referencia
    )
    propertiesTextViewComposable.text?.let {
        Box(
            modifier = Modifier
                .height(scaledWidth)
                .width(scaledHeight)
                .background(color =
                    if(propertiesTextViewComposable.background != null){
                        HexToJetpackColor.getColor(propertiesTextViewComposable.background)
                    }else{
                        Color.White
                    }
                ),
            contentAlignment = getAligment(
                (propertiesTextViewComposable.textAlignment ?: AligmentEnum.MEDIUMCENTER).toString()
            )
        )
        {
            Text(
                modifier = Modifier
                    .clickable {
                        if (actions != null) {
                            onClick.invoke(actions,
                                DataAnalitic(id = propertiesTextViewComposable.idAnalytics ?: "", action = propertiesTextViewComposable.actionAnalytics ?: "")
                            )
                        }
                    },
                text = it,
                fontSize = if(propertiesTextViewComposable.fontSize != null){propertiesTextViewComposable.fontSize.sp} else {
                    12.sp
                },
                color = if(propertiesTextViewComposable.colorText != null){
                    HexToJetpackColor.getColor(propertiesTextViewComposable.colorText)
                }else{Color.Black}
            )
        }
    }

}


