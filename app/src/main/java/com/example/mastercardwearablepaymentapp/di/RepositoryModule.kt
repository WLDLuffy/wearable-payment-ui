package com.example.mastercardwearablepaymentapp.di

import com.example.mastercardwearablepaymentapp.onboarding.data.repositoryImpl.ProductRepositoryImpl
import com.example.mastercardwearablepaymentapp.onboarding.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProductsRepository(
        impl: ProductRepositoryImpl
    ): ProductsRepository
}