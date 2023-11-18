package com.richterapps.sduicompose.domain

data class ComponentListModel(
    var componentList: List<ComponentModel>? = listOf(),
)

data class ComponentModel(
    var type: String = "",
    var subType: String? = null,
    var params: Map<String, Any?>? = null,
    var content: ComponentModel? = null,
    var modifierModel: ModifierModel? = null,
    var deeplink: String? = null
)

data class ModifierModel(
    var params: Map<String, Any?>? = null,
)