package com.project.minisoundsapp.api

class RemoteConfigRepository {
    suspend fun getRemoteConfig() = RetrofitInstance.remoteConfig.getRemoteConfig()
}