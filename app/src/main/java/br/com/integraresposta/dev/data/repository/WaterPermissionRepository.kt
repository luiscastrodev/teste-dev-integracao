package br.com.integraresposta.dev.data.repository

import br.com.integraresposta.dev.data.dto.WaterPemissionsResponse
import br.com.integraresposta.dev.data.remote.ApiError
import br.com.integraresposta.dev.data.remote.ApiService
import br.com.integraresposta.dev.domain.IWaterPermissionRepository
import com.google.gson.Gson
import retrofit2.HttpException
import javax.inject.Inject


class WaterPermissionRepository @Inject constructor(
    private val apiService: ApiService,
): IWaterPermissionRepository {
   override suspend fun getWaterPermissions(): Result<WaterPemissionsResponse> {
        return try {
            val response = apiService.getWaterPermissions()
            Result.success(response)
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val apiError: ApiError? = try {
                Gson().fromJson(errorBody, ApiError::class.java)
            } catch (jsonException: Exception) {
                null
            }
            Result.failure(RuntimeException(apiError?.err ?: "Erro desconhecido"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
