// LaSobremesa
// la vista del menu del carrito
//
package com.example.lasobremesa.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lasobremesa.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CartItem(
    val id: String,
    val title: String,
    val brand: String,
    val type: String, // Ej: "Refrigerado", "Ambiente"
    val deliveryInfo: String,
    val price: Double,
    val quantity: Int,
    val imageRes: Int
)

data class CartUiState(
    val items: List<CartItem> = emptyList(),
    val isLoading: Boolean = false
) {
    val subtotal: Double
        get() = items.sumOf { it.price * it.quantity }
    val totalItemsCount: Int
        get() = items.sumOf { it.quantity }
}

class CartViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CartUiState())
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        // Datos de ejemplo basados en tu diseño wireframe
        _uiState.value = CartUiState(
            items = listOf(
                CartItem(
                    id = "1",
                    title = "Queso Maduro Artesanal",
                    brand = "Don Pedro",
                    type = "Refrigerado",
                    deliveryInfo = "Entrega 22-24 ago",
                    price = 12990.0,
                    quantity = 1,
                    imageRes = R.drawable.img_queso_maduro
                ),
                CartItem(
                    id = "2",
                    title = "Mermelada de Frambuesa",
                    brand = "Gustoso Gourmet",
                    type = "Ambiente",
                    deliveryInfo = "Entrega 21-23 ago",
                    price = 6990.0,
                    quantity = 2,
                    imageRes = R.drawable.img_merm_frambuesa
                )
            )
        )
    }

    fun updateQuantity(itemId: String, newQuantity: Int) {
        if (newQuantity <= 0) {
            removeItem(itemId)
            return
        }
        _uiState.update { currentState ->
            val updatedItems = currentState.items.map { item ->
                if (item.id == itemId) item.copy(quantity = newQuantity) else item
            }
            currentState.copy(items = updatedItems)
        }
    }

    fun removeItem(itemId: String) {
        _uiState.update { currentState ->
            currentState.copy(items = currentState.items.filter { it.id != itemId })
        }
    }
}