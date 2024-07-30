package com.example.cleanarchshoplist.presentation

import android.app.Application
import com.example.cleanarchshoplist.di.DaggerApplicationComponent

class ShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}