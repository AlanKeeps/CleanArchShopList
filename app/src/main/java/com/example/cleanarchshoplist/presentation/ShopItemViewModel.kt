package com.example.cleanarchshoplist.presentation

import androidx.lifecycle.ViewModel
import com.example.cleanarchshoplist.data.ShopListRepositoryImpl
import com.example.cleanarchshoplist.domain.AddShopItemUseCase
import com.example.cleanarchshoplist.domain.EditShopItemUseCase
import com.example.cleanarchshoplist.domain.GetShopItemUseCase
import com.example.cleanarchshoplist.domain.ShopItem

class ShopItemViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun getShopItem(shopItemId: Int){
        val item = getShopItemUseCase.getShopItem(shopItemId)
    }

    fun addShopItem(inputName: String?, inputCount: String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValis = validateInput(name, count)
        if (fieldsValis){
            val shopItem = ShopItem(name, count, true)
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValis = validateInput(name, count)
        if (fieldsValis){
            val shopItem = ShopItem(name, count, true)
            editShopItemUseCase.editShopItem(shopItem)
        }
    }


    private fun parseName(inputName: String?): String{
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int{
        return try {
            inputCount?.trim()?.toInt() ?: 0
        }catch (e: Exception){
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean{
        var result = true
        if (name.isBlank()){
            // todo : show error inputName
            result = false
        }
        if (count <= 0){
            // todo : show error inputcount
            result = false
        }
        return result
    }
}
