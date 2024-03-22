package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class Actions(
    @SerializedName("common")
    val common: Common,
    @SerializedName("network")
    val network: Network
)