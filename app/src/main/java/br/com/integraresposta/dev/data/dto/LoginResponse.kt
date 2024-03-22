package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("block")
    val block: Boolean,
    @SerializedName("endTimePause")
    val endTimePause: String,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("startTimePause")
    val startTimePause: String,
    @SerializedName("Token")
    val token: String,
    @SerializedName("TrackingToken")
    val trackingToken: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("userid")
    val userid: String
)