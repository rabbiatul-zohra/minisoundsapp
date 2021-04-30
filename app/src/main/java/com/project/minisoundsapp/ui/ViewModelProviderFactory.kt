package com.project.minisoundsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.minisoundsapp.service.RemoteConfigService
import com.project.minisoundsapp.ui.viewmodels.KillSwitchViewModel

class ViewModelProviderFactory(private val remoteConfigService: RemoteConfigService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return KillSwitchViewModel(remoteConfigService) as T
    }
}