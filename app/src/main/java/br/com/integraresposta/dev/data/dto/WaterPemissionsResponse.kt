package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class WaterPemissionsResponse(
    @SerializedName("actions")
    val actions: Actions
)