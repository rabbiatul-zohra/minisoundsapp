package com.example.mini_sounds_app.api

import com.example.mini_sounds_app.ui.models.RemoteConfig
import retrofit2.Response
import retrofit2.http.GET


interface RemoteConfig {
    @GET("/android/1.22.1/config.json")
    suspend fun getRemoteConfig(): Response<RemoteConfig>
}