package com.project.minisoundsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.project.minisoundsapp.service.RemoteConfigService
import com.project.minisoundsapp.ui.models.RemoteConfigStatus
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