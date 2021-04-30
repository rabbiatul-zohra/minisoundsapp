package com.project.minisoundsapp.service

import com.project.minisoundsapp.api.RemoteConfigRepository

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