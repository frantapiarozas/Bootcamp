// La Sobremesa
// pantalla de productos
//
package com.example.lasobremesa.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lasobremesa.ui.viewmodel.ProductsViewModel
import com.example.lasobremesa.ui.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogScreen(
    navController: NavController,
    viewModel: ProductsViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Reemplazamos el botón por una lista horizontal de filtros
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val categorias = listOf("Todos", "Quesos", "Mermeladas", "Aceite Oliva", "Vinos", "Conservas")

                items(categorias) { categoria ->
                    val isSelected = state.selectedCategories.contains(categoria)

                    FilterChip(
                        selected = isSelected,
                        onClick = { viewModel.onCategoryToggled(categoria) },
                        label = { Text(categoria) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Grilla de Productos que ya tienes
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.products) { product ->
                    ProductCard(
                        product = product,
                       onClick = { productId ->
                           if (!productId.isNullOrEmpty()) {
                               navController.navigate("ProductDetailScreen/$productId")
                           }
                       }
                    )
                }
            }
        }
    }
}



