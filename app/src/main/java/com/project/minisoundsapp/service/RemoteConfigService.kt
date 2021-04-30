package com.project.minisoundsapp.service

import com.project.minisoundsapp.api.RemoteConfigRepository
import com.project.minisoundsapp.ui.models.RemoteConfig
import com.project.minisoundsapp.util.Resource
import retrofit2.Response

class RemoteConfigService(private val remoteConfigRepository: RemoteConfigRepository) {
    private lateinit var remoteConfig: RemoteConfig

    suspend fun getRemoteConfig(): RemoteConfig? {
        val response = remoteConfigRepository.getRemoteConfig()
        return handleRemoteConfigResponse(response).data
    }

    private fun handleRemoteConfigResponse(response: Response<RemoteConfig>): Resource<RemoteConfig> {
        if(response.isSuccessful) {
            response.body()?.let {
                remoteConfig = it
            }
            return Resource.Success(remoteConfig)
        }
        return Resource.Error(response.message())
    }
}