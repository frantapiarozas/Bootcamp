// LaSobremesa
// la vista de los productos disponibles
//
package com.example.lasobremesa.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lasobremesa.data.ProducerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.lasobremesa.data.Product
import com.example.lasobremesa.data.ProductRepository
import kotlinx.coroutines.flow.update

class ProductsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CatalogUiState())
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()
    private val productRepository = ProductRepository()
    private val producerRepository = ProducerRepository()

    init {
        val listaProductosIniciales = productRepository.getProducts()

        _uiState.update {
            it.copy(
                allProducts = listaProductosIniciales,
                products = listaProductosIniciales
            )
        }
    }


    fun onCategoryToggled(category: String) {
        val currentCategories = _uiState.value.selectedCategories.toMutableSet()
        if (category == "Todos") {
            if (currentCategories.contains("Todos")) {
                currentCategories.remove("Todos")
            } else {
                // Si marcan "Todos", limpiamos las demás y dejamos solo "Todos"
                currentCategories.clear()
                currentCategories.add("Todos")
            }
        } else {
            // Si marcan otra categoría, quitamos "Todos" para que no convivan
            currentCategories.remove("Todos")

            if (currentCategories.contains(category)) {
                currentCategories.remove(category)
            } else {
                currentCategories.add(category)
            }
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

    private fun updateFilteredProducts(newCategories: Set<String> =
     _uiState.value.selectedCategories,
        newProducers: Set<String> = _uiState.value.selectedProducers
    ) {
        val all = _uiState.value.allProducts
        val filtered = all.filter { product ->
            val matchesCategory = newCategories.isEmpty() || newCategories.contains("Todos") || newCategories.contains(product.category)
            val matchesProducer = newProducers.isEmpty() || newProducers.contains(product.producerId)
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