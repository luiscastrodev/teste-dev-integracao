package br.com.integraresposta.dev.data.repository

import android.content.SharedPreferences
import br.com.integraresposta.dev.data.dto.LoginResponse
import br.com.integraresposta.dev.data.remote.ApiError
import br.com.integraresposta.dev.data.remote.ApiService
import br.com.integraresposta.dev.domain.IUserRepository
import com.google.gson.Gson
import retrofit2.HttpException
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val sharedPreferences: SharedPreferences
): IUserRepository {
   override suspend fun login(username: String, password: String): Result<LoginResponse> {
        return try {
            val response = apiService.login(username, password)
            sharedPreferences.edit().putString("token", response.token).apply()
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
