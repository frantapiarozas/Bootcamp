// LaSobremesa
// la vista del home
//
package com.example.lasobremesa.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lasobremesa.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Modelo de datos para las categorías de productos requeridas
data class Product(
    val id: String,
    val name: String,
    val imageRes: Int
)

data class HomeUiState(
    val mainTitle: String = "Sabores artesanales\ncon historia",
    val mainDescription: String = "Productos de productores de la zona central de Chile, con despacho seguro a todo el país.",
    // Las 5 categorías solicitadas: Queso, Mermelada, Aceite oliva, Vino y Conservas
    val categories: List<Product> = listOf(
        Product("1", "Quesos", R.drawable.img_queso),
        Product("2", "Mermeladas", R.drawable.img_mermelada),
        Product("3", "Aceite oliva", R.drawable.img_aceite),
        Product("4", "Vinos", R.drawable.img_vino),
        Product("5", "Conservas", R.drawable.img_conservas)
    ),
    val gourmetBoxTitle: String = "CAJA GOURMET MENSUAL",
    val gourmetBoxDescription: String = "Una selección curada de productos artesanales, todos los meses en tu casa.",
    val gourmetBoxImageRes: Int = R.drawable.img_caja
)

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onCategoryClick(product: Product) {
        // Lógica al presionar una categoría
    }
}