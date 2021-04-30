package com.project.minisoundsapp.api

import com.project.minisoundsapp.ui.models.RemoteConfig
import retrofit2.Response
import retrofit2.http.GET


interface RemoteConfig {
    @GET("/android/1.22.1/config.json")
    suspend fun getRemoteConfig(): Response<RemoteConfig>
}