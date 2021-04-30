package com.example.mini_sounds_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mini_sounds_app.service.RemoteConfigService
import com.example.mini_sounds_app.ui.viewmodels.KillSwitchViewModel

class ViewModelProviderFactory(private val remoteConfigService: RemoteConfigService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return KillSwitchViewModel(remoteConfigService) as T
    }
}