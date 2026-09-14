// LaSobremesa
// la vista de los productos disponibles
//
package com.example.lasobremesa.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lasobremesa.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.lasobremesa.data.Product
import kotlinx.coroutines.flow.update

class ProductsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CatalogUiState())
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    init {
        val listaProductosIniciales = listOf(
            Product(
                id = "1",
                name = "Queso Maduro",
                category = "Quesos",
                producer = "Don Pedro",
                imageRes = R.drawable.img_queso_maduro, // El mismo recurso que usas en el carrito
                price = 12990
            ),
            Product(
                id = "2",
                name = "Mermelada de Frambuesa",
                category = "Mermeladas",
                producer = "Gustoso Gourmet",
                imageRes = R.drawable.img_merm_frambuesa,
                price = 13980
            )
        )

        _uiState.update {
            it.copy(
                allProducts = listaProductosIniciales,
                products = listaProductosIniciales
            )
        }
    }


    fun onCategoryToggled(category: String) {
        val currentCategories = _uiState.value.selectedCategories.toMutableSet()
        if (currentCategories.contains(category)) {
            currentCategories.remove(category)
        } else {
            currentCategories.add(category)
        }
        updateFilteredProducts(newCategories = currentCategories)
    }

    fun onProducerToggled(producer: String) {
        val currentProducers = _uiState.value.selectedProducers.toMutableSet()
        if (currentProducers.contains(producer)) {
            currentProducers.remove(producer)
        } else {
            currentProducers.add(producer)
        }
        updateFilteredProducts(newProducers = currentProducers)
    }

    private fun updateFilteredProducts(
        newCategories: Set<String> = _uiState.value.selectedCategories,
        newProducers: Set<String> = _uiState.value.selectedProducers
    ) {
        val all = _uiState.value.allProducts
        val filtered = all.filter { product ->
            val matchesCategory = newCategories.isEmpty() || newCategories.contains(product.category)
            val matchesProducer = newProducers.isEmpty() || newProducers.contains(product.producer)
            matchesCategory && matchesProducer
        }

        _uiState.update {
            it.copy(
                products = filtered,
                selectedCategories = newCategories,
                selectedProducers = newProducers
            )
        }
    }
}

data class CatalogUiState(
        val allProducts: List<Product> = emptyList(), // Lista maestra para no perder los datos
        val products: List<Product> = emptyList(),    // Lista que se muestra en pantalla (filtrada)
        val selectedCategories: Set<String> = emptySet(),
        val selectedProducers: Set<String> = emptySet(),
        val isLoading: Boolean = false
    )