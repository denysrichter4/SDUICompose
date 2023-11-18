package com.richterapps.sduicompose.domain

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ConvertJsonToComponentListModel(listModel: ComponentListModel) {
    listModel.componentList?.forEach { model ->
        ConvertComponentModelToCompose(model)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConvertComponentModelToCompose(model: ComponentModel) {
    val modifierModel = model.modifierModel?.let { modifier(it) }!!
    when(model.type){
        ComponentTypes.BOX.name -> {
            Box(modifier = modifierModel)
        }
        ComponentTypes.BUTTON.name -> {
            Button(
                onClick = {
                    model.deeplink?.let { deeplinkRedirect(it) }
                }
            ) {
                model.content?.let { ConvertComponentModelToCompose(model = it) }
            }
        }
        ComponentTypes.COLUMN.name -> {
            Column {

            }
        }
        ComponentTypes.IMAGE.name -> {
            Image(painter = painterResource(id = 0), contentDescription = "")
        }
        ComponentTypes.ROW.name -> {
            Row {

            }
        }
        ComponentTypes.SCAFFOLD.name -> {
            Scaffold(
                bottomBar = {

                }
            ) {
                Box(Modifier.padding(it))
            }
        }
        ComponentTypes.SURFACE.name -> {
            Surface {

            }
        }
        ComponentTypes.TEXT.name -> {
            Text(text = "")
        }
        ComponentTypes.TEXT_FIELD.name -> {
            TextField(value = "", onValueChange = {})
        }
    }
}

private fun modifier(modifierModel: ModifierModel): Modifier {
    val modifier = Modifier
    modifierModel.params?.forEach { param ->
        when(param.key){
            "padding" -> { modifier.padding(param.value.toString().toInt().dp) }
            "width" -> { modifier.padding(param.value.toString().toInt().dp) }
            "height" -> { modifier.padding(param.value.toString().toInt().dp) }
        }
    }
    return modifier
}