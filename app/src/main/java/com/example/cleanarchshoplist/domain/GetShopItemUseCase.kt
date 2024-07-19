package com.example.cleanarchshoplist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItemId(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItemId(shopItemId)
    }
}