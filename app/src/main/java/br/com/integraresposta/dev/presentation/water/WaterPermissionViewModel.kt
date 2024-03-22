package br.com.integraresposta.dev.presentation.water

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.integraresposta.dev.data.dto.LoginResponse
import br.com.integraresposta.dev.data.dto.WaterPemissionsResponse
import br.com.integraresposta.dev.data.repository.UserRepository
import br.com.integraresposta.dev.data.repository.WaterPermissionRepository
import br.com.integraresposta.dev.domain.IWaterPermissionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WaterPermissionViewModel @Inject constructor(
    private val  waterPermissionRepository: IWaterPermissionRepository
) : ViewModel() {

    private val _waterPermissionResult = MutableLiveData<Result<WaterPemissionsResponse>>()
    val waterPermissionResult: LiveData<Result<WaterPemissionsResponse>> = _waterPermissionResult


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getWaterPermissions() {
        _isLoading.value = true

        viewModelScope.launch {
            val result = waterPermissionRepository.getWaterPermissions()
            _waterPermissionResult.value = result
            _isLoading.value = false
        }
    }
}