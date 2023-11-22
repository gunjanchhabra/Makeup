package com.domain.di

import com.domain.usecases.ProductDetailUseCase
import com.domain.usecases.ProductDetailUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductDetailModule {

    @Binds
    abstract fun bindProductDetailUseCase(productDetailUseCaseImpl: ProductDetailUseCaseImpl) : ProductDetailUseCase
}