package com.example.lasobremesa.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import com.example.lasobremesa.data.CartItem
import com.example.lasobremesa.data.CartRepository
import com.example.lasobremesa.data.Product
import com.example.lasobremesa.data.ProductRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel (
    savedStateHandle: SavedStateHandle = SavedStateHandle(),
    private val repository: ProductRepository = ProductRepository()
) : ViewModel() {
    private val productId: String? = savedStateHandle["productId"]

    // Obtenemos el producto directamente del repositorio según su ID
    val product: Product? = productId?.let { repository.getProductById(it)}

    //estado local para la cantidad de producto especifico
    private val _quantity = mutableStateOf(0)
    val quantity: State<Int> = _quantity

    //funciones para actualizar la cantidad de ese viewmodel
    fun updateQuantity(newQuantity: Int){
        if (newQuantity >=0){
            _quantity.value = newQuantity
        }
    }
    fun addToCart (product:Product, selectedQuantity: Int) {
        if (selectedQuantity <=0) return
        viewModelScope.launch {
            val cartItem = CartItem(
                id = product.id,
                title = product.name,
                brand = product.producerId,
                type = product.category,
                deliveryInfo = product.description,
                price = product.price.toDouble(),
                quantity = selectedQuantity,
                imageRes = product.imageRes
            )
            CartRepository.addToCart(cartItem)
        }
    }
}
