package br.com.integraresposta.dev.domain

import br.com.integraresposta.dev.data.dto.WaterPemissionsResponse

interface IWaterPermissionRepository {
    suspend fun getWaterPermissions(): Result<WaterPemissionsResponse>
}