package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class Parameters(
    @SerializedName("CHK")
    val cHK: CHK,
    @SerializedName("IP1")
    val iP1: IP1,
    @SerializedName("IP2")
    val iP2: IP1,
    @SerializedName("MeterID")
    val meterID: MeterID,
    @SerializedName("PORT1")
    val pORT: PORT,
    @SerializedName("PORT2")
    val pORT2: PORT
)