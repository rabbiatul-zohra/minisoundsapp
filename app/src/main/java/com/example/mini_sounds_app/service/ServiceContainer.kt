package com.example.mini_sounds_app.service

import com.example.mini_sounds_app.api.RemoteConfigRepository

class ServiceContainer(
        val remoteConfigService: RemoteConfigService
) {

    object Factory {
        fun create(): ServiceContainer {
            val remoteConfigService = createRemoteConfigService()
            return ServiceContainer(
                    remoteConfigService
            )
        }

        private fun createRemoteConfigService(): RemoteConfigService {
            val remoteConfigRepository = RemoteConfigRepository()
            return RemoteConfigService(remoteConfigRepository)
        }
    }
}