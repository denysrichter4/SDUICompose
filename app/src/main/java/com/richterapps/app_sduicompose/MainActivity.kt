package com.richterapps.app_sduicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.richterapps.app_sduicompose.ui.theme.SDUIComposeTheme
import com.richterapps.sduicompose.SDUICompose
import com.richterapps.sduicompose.common.SDUIComposeCallback

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SDUIComposeTheme {
                SDUICompose(
                    object: SDUIComposeCallback { override fun getJson(): String = "" }
                ).Start()
            }
        }
    }
}