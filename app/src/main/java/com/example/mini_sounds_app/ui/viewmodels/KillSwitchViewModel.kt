package com.example.mini_sounds_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mini_sounds_app.service.RemoteConfigService
import com.example.mini_sounds_app.ui.models.RemoteConfigStatus
import kotlinx.coroutines.runBlocking

class KillSwitchViewModel(private val remoteConfigService: RemoteConfigService): ViewModel() {

    private lateinit var status: RemoteConfigStatus

    fun getStatus(): RemoteConfigStatus {
        runBlocking {
            remoteConfigService.getRemoteConfig()?.let {
                status = it.status
            }
        }
        return status
    }
}