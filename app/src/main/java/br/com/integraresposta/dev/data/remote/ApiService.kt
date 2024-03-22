package br.com.integraresposta.dev.data.remote

import br.com.integraresposta.dev.data.dto.LoginResponse
import br.com.integraresposta.dev.data.dto.WaterPemissionsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("login")
    suspend fun login(@Field("u") userName : String ,@Field("p") password : String): LoginResponse

    @GET("waterPermissions")
    suspend fun getWaterPermissions(): WaterPemissionsResponse
}