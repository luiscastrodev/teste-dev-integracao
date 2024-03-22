package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class SetIP(
    @SerializedName("label")
    val label: String,
    @SerializedName("parameters")
    val parameters: Parameters,
    @SerializedName("payload")
    val payload: String
)