package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class PORT(
    @SerializedName("label")
    val label: String,
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int,
    @SerializedName("required")
    val required: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)