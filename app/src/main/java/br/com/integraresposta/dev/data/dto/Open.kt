package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class Open(
    @SerializedName("label")
    val label: String,
    @SerializedName("payload")
    val payload: String
)