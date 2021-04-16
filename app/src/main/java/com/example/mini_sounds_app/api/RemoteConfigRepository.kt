package com.example.mini_sounds_app.api

class RemoteConfigRepository {
    suspend fun getRemoteConfig() = RetrofitInstance.remoteConfig.getRemoteConfig()
}