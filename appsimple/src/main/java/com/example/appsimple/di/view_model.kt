package com.example.appsimple.di

import com.example.appsimple.ui.data_lib.DataLibViewModel
import com.example.appsimple.ui.data_lib.data_store.DataStoreViewModel
import com.example.appsimple.ui.data_lib.green_dao.GreenDaoFragment
import com.example.appsimple.ui.data_lib.green_dao.GreenDaoViewModel
import com.example.appsimple.ui.data_lib.mmkv.MmkvViewModel
import com.example.appsimple.ui.data_lib.object_box.ObjectBoxViewModel
import com.example.appsimple.ui.data_lib.sp.DataSpViewModel
import com.example.appsimple.ui.glide.GlideViewModel
import com.example.appsimple.ui.glide_plaette.GlidePaletteViewModel
import com.example.appsimple.ui.main.MainViewModel
import com.example.appsimple.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { GlideViewModel() }
    viewModel { GlidePaletteViewModel() }
    viewModel { SplashViewModel() }
    viewModel { DataLibViewModel() }
    viewModel { DataSpViewModel() }
    viewModel { DataStoreViewModel() }
    viewModel { MmkvViewModel() }
    viewModel { ObjectBoxViewModel() }
    viewModel { GreenDaoViewModel() }
}