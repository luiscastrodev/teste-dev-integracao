package br.com.integraresposta.dev.data.dto


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("open")
    val `open`: Open
)