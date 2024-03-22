package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class IP1(
    @SerializedName("label")
    val label: String,
    @SerializedName("required")
    val required: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)