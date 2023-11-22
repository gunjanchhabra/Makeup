package com.domain.di

import com.domain.usecases.ProductListUseCase
import com.domain.usecases.ProductListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductListModule {
    @Binds
    abstract fun bindProductListUseCase(productListUseCaseImpl: ProductListUseCaseImpl) : ProductListUseCase
}