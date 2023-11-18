package com.richterapps.sduicompose

import androidx.compose.runtime.Composable
import com.richterapps.sduicompose.common.SDUIComposeCallback
import com.richterapps.sduicompose.domain.ComponentListModel
import com.richterapps.sduicompose.domain.ConvertJsonToComponentListModel
import com.richterapps.sduicompose.domain.convertJsonToModel

class SDUICompose(private val callback: SDUIComposeCallback){
    @Composable
    fun Start(){
        ConvertJsonToComponentListModel(
            ComponentListModel().convertJsonToModel(callback.getJson())
        )
    }
}