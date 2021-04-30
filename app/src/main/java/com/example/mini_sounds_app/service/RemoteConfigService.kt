package com.example.mini_sounds_app.service

import com.example.mini_sounds_app.api.RemoteConfigRepository
import com.example.mini_sounds_app.ui.models.RemoteConfig
import com.example.mini_sounds_app.util.Resource
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class RemoteConfigService(private val remoteConfigRepository: RemoteConfigRepository) {
    private lateinit var remoteConfig: RemoteConfig

    fun getRemoteConfig(): RemoteConfig? {
        return runBlocking {
            val response = remoteConfigRepository.getRemoteConfig()
            handleRemoteConfigResponse(response).data
        }
    }

    private fun handleRemoteConfigResponse(response: Response<RemoteConfig>): Resource<RemoteConfig> {
        if(response.isSuccessful) {
            response.body()?.let {
                remoteConfig = it
            }
        }
        return Resource.Success(remoteConfig)
    }
}