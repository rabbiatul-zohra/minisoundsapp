package com.project.minisoundsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.project.minisoundsapp.MainActivity
import com.project.minisoundsapp.R
import com.project.minisoundsapp.ui.viewmodels.KillSwitchViewModel

class KillSwitchFragment: Fragment() {
    lateinit var viewModel: KillSwitchViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kill_switch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        setStatusTitle(view)
    }

    fun setStatusTitle(view: View) {
        val statusTitle = view.findViewById<TextView>(R.id.app_killed_title)
        val status = viewModel.getStatus()
        statusTitle.text = status.title
    }
}