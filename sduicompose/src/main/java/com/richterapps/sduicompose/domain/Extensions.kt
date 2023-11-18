package com.richterapps.sduicompose.domain

import com.google.gson.Gson

inline fun <reified T: Any?> T.convertJsonToModel(json: String): T {
   return Gson().fromJson(json, T::class.java)
}

fun deeplinkRedirect(deeplink: String) {

}