package com.example.cleanarchshoplist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemId(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItemId(shopItemId)
    }
}