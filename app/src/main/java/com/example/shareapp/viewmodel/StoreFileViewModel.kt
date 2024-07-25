package com.example.shareapp.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shareapp.view.fragments.PhotoFragment

class StoreFileViewModel: ViewModel() {
    val selectedFragment = MutableLiveData<Fragment>()

    init {
        selectedFragment.value = PhotoFragment()
    }

    fun selectFragment(fragment: Fragment) {
        selectedFragment.value = fragment
    }
}