package br.com.integraresposta.dev.domain

import br.com.integraresposta.dev.data.dto.LoginResponse

interface IUserRepository {
    suspend fun login(username: String, password: String): Result<LoginResponse>
}