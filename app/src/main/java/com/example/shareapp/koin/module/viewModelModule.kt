package com.example.shareapp.koin.module

import com.example.shareapp.viewmodel.StoreFileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        StoreFileViewModel()
    }
}