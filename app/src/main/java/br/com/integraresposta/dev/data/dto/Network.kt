package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("items")
    val items: ItemsX,
    @SerializedName("label")
    val label: String
)