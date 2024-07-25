package com.example.shareapp.view.tabLayout

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.shareapp.view.fragments.PhotoFragment
import com.example.shareapp.view.fragments.VideoFragment
import com.example.shareapp.viewmodel.MainViewModel
import com.example.shareapp.viewmodel.StoreFileViewModel
import com.google.android.material.tabs.TabLayout

class TabManager(
    private val viewModel: StoreFileViewModel,
    tabLayout: TabLayout,
) {
    init {
        tabLayout.addTab(tabLayout.newTab().setText("Photo"))
        tabLayout.addTab(tabLayout.newTab().setText("Video"))
        tabLayout.addTab(tabLayout.newTab().setText("File"))
        tabLayout.addTab(tabLayout.newTab().setText("App"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> viewModel.selectFragment(PhotoFragment())
                    1 -> viewModel.selectFragment(VideoFragment())
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Do nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Do nothing
            }
        })
    }
}