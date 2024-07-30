package com.example.cleanarchshoplist.di

import android.app.Application
import com.example.cleanarchshoplist.data.AppDatabase
import com.example.cleanarchshoplist.data.ShopListDao
import com.example.cleanarchshoplist.data.ShopListRepositoryImpl
import com.example.cleanarchshoplist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object{

        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}