package com.example.cleanarchshoplist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItemId(shopItemId: Int): ShopItem

    fun getShopList(): List<ShopItem>


}