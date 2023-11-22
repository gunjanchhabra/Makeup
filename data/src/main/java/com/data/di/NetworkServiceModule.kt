package com.data.di

import com.data.network.NetworkService
import com.data.network.NetworkServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class NetworkServiceModule {
    @Binds
    abstract fun bindNetworkService(networkServiceImpl: NetworkServiceImpl) : NetworkService
}