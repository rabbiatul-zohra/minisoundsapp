package com.example.mini_sounds_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mini_sounds_app.api.RemoteConfigRepository
import com.example.mini_sounds_app.ui.viewmodels.KillSwitchViewModel

class ViewModelProviderFactory(private val remoteConfigRepository: RemoteConfigRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return KillSwitchViewModel(remoteConfigRepository) as T
    }
}