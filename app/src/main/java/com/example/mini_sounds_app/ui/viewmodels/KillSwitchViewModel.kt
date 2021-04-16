package com.example.mini_sounds_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mini_sounds_app.api.RemoteConfigRepository
import com.example.mini_sounds_app.ui.models.RemoteConfig
import com.example.mini_sounds_app.ui.models.RemoteConfigStatus
import com.example.mini_sounds_app.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class KillSwitchViewModel(private val remoteConfigRepository: RemoteConfigRepository): ViewModel() {
    private lateinit var remoteConfig: RemoteConfig
    var status: RemoteConfigStatus? = null

    init {
        getRemoteConfigStatus()
    }

    private fun getRemoteConfigStatus() {
        viewModelScope.launch {
            val response = remoteConfigRepository.getRemoteConfig()
            status = handleRemoteConfigResponse(response).data?.status
        }
    }

    private fun handleRemoteConfigResponse(response: Response<RemoteConfig>): Resource<RemoteConfig> {
        viewModelScope.launch {
            if(response.isSuccessful) {
                response.body()?.let {
                    remoteConfig = it
                    Resource.Success(remoteConfig.status)
                }
            }
        }
        return Resource.Error(response.message())
    }
}