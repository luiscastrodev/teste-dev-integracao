package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class Common(
    @SerializedName("items")
    val items: Items,
    @SerializedName("label")
    val label: String
)