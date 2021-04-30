package com.example.mini_sounds_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.mini_sounds_app.api.RemoteConfigRepository
import com.example.mini_sounds_app.fragments.KillSwitchFragment
import com.example.mini_sounds_app.service.RemoteConfigService
import com.example.mini_sounds_app.service.ServiceContainer
import com.example.mini_sounds_app.ui.ViewModelProviderFactory
import com.example.mini_sounds_app.ui.viewmodels.KillSwitchViewModel


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: KillSwitchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = createViewModelProviderFactory().get(KillSwitchViewModel::class.java)

        val manager: FragmentManager = supportFragmentManager
        val fragment= KillSwitchFragment()
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_layout, fragment).addToBackStack(null)
        transaction.commit()

    }

    private fun createViewModelProviderFactory(): ViewModelProvider {
        val serviceFactory = ServiceContainer.Factory.create()
        val viewModelProviderFactory = ViewModelProviderFactory(serviceFactory.remoteConfigService)
        return ViewModelProvider(this, viewModelProviderFactory)
    }
}